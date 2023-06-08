package cs3500.pa04.client;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs3500.pa04.controller.Controller;
import cs3500.pa04.json.CoordJson;
import cs3500.pa04.json.FleetJson;
import cs3500.pa04.json.GameResultJson;
import cs3500.pa04.json.GameType;
import cs3500.pa04.json.JsonUtils;
import cs3500.pa04.json.MessageJson;
import cs3500.pa04.json.PlayerJson;
import cs3500.pa04.json.SetupJson;
import cs3500.pa04.json.ShipDirection;
import cs3500.pa04.json.ShipJson;
import cs3500.pa04.json.VolleyJson;
import cs3500.pa04.model.Coord;
import cs3500.pa04.model.GameResult;
import cs3500.pa04.model.Player;
import cs3500.pa04.model.Ship;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Represent a proxy controller that will communicate
 * between a Player and a Server
 */
public class ProxyDealer implements Controller {
  private final Socket server;
  private final Player aiPlayer;
  private final InputStream in;
  private final PrintStream out;
  private final ObjectMapper mapper = new ObjectMapper();
  private static final JsonNode VOID_RESPONSE =
      new ObjectMapper().getNodeFactory().textNode("void");

  /**
   * Initialize the ProxyController that will be receiving
   * and sending messages between the given player and the given server
   *
   * @param server The server that will host the game
   * @param aiPlayer This CPU's Player
   */
  public ProxyDealer(Socket server, Player aiPlayer) {
    this.server = server;
    this.aiPlayer = aiPlayer;
    try {
      this.in = server.getInputStream();
      this.out = new PrintStream(server.getOutputStream());
    } catch (IOException err) {
      throw new IllegalArgumentException("The given socket does not have a "
          + "valid input or output stream");
    }
  }


  /**
   * Runs the game by continuously receiving messages from the socket
   * and pass them to delegateMessage to be handled
   */
  @Override
  public void run() {
    try {
      JsonParser parser = this.mapper.getFactory().createParser(this.in);

      while (!this.server.isClosed()) {
        MessageJson message = parser.readValueAs(MessageJson.class);
        delegateMessage(message);
      }
    } catch (IOException e) {
      // Disconnected from server or parsing exception
    }
  }

  /**
   * Determines the type of request the server has sent and delegates to the
   * corresponding helper method with the message arguments.
   *
   * @param message the MessageJSON used to determine what the server has sent
   */
  private void delegateMessage(MessageJson message) {
    String name = message.methodCall();
    JsonNode arguments = message.arguments();

    switch (name) {
      case "join" -> handleJoin();
      case "setup" -> handleSetup(arguments);
      case "take-shots" -> handleTakeShots();
      case "report-damage" -> handleReportDamage(arguments);
      case "successful-hits" -> handleSuccessfulHits(arguments);
      case "end-game" -> handleEndGame(arguments);
    }
  }

  /**
   * Return this player's name as a Json message to join the game
   */
  private void handleJoin() {
    PlayerJson response = new PlayerJson(this.aiPlayer.name(), GameType.SINGLE);

    JsonNode jsonArgResponse = JsonUtils.serializeRecord(response);
    MessageJson joinResponse = new MessageJson("join", jsonArgResponse);
    JsonNode jsonResponse = JsonUtils.serializeRecord(joinResponse);
    this.out.println(jsonResponse);
  }

  /**
   * Return this player's fleet as a Json message to join the game
   *
   * @param arguments the JsonNode containing the height, width, and the specification
   *                  for the fleet for this player to set up their board and fleet
   */
  private void handleSetup(JsonNode arguments) {
    //will require a SetupJson or some sort of object to take in server input
    SetupJson setupArgs  = this.mapper.convertValue(arguments, SetupJson.class);

    List<Ship> fleet = this.aiPlayer.setup(setupArgs.height(), setupArgs.width(),
        setupArgs.fleetSpec());


    List<ShipJson> fleetJson = new ArrayList<>();
    for (Ship s : fleet) {
      List<Coord> coords = s.getLocation();
      Coord headCoord = coords.get(0);

      //turn the head coord into a coordJson
      CoordJson headJson = new CoordJson(headCoord.getXpos(), headCoord.getYpos());

      //get ship direction
      ShipDirection isVertical;
      if (coords.get(0).getXpos() == coords.get(1).getXpos()) {
        isVertical = ShipDirection.VERTICAL;
      } else {
        isVertical = ShipDirection.HORIZONTAL;
      }
      fleetJson.add(new ShipJson(headJson, coords.size(), isVertical));
    }

    //will return a FleetJson to server'
    FleetJson response = new FleetJson(fleetJson);
    JsonNode jsonArgResponse = JsonUtils.serializeRecord(response);
    MessageJson setupResponse = new MessageJson("setup", jsonArgResponse);
    JsonNode jsonResponse = JsonUtils.serializeRecord(setupResponse);
    this.out.println(jsonResponse);
  }


  /**
   * Return this player's shots on opponent's board as a Json Message
   */
  private void handleTakeShots() {
    List<Coord> shots = this.aiPlayer.takeShots();
    List<CoordJson> coordJsons = constructResponseList(shots);


    VolleyJson response = new VolleyJson(coordJsons);
    JsonNode jsonArgResponse = JsonUtils.serializeRecord(response);
    MessageJson takeshotsResponse = new MessageJson("take-shots", jsonArgResponse);
    JsonNode jsonResponse = JsonUtils.serializeRecord(takeshotsResponse);

    this.out.println(jsonResponse);
  }


  /**
   * Take in the opponent's chosen shots and
   * return a list containing the shots that hit any of this player's ships
   *
   * @param arguments the JsonNode containing the opponent's list of chosen
   *                  shots on this player's board
   */
  private void handleReportDamage(JsonNode arguments) {
    VolleyJson opponentShots = this.mapper.convertValue(arguments, VolleyJson.class);
    List<Coord> aiSuccesfulHits = this.aiPlayer.reportDamage(opponentShots.makeCoordList());
    List<CoordJson> coordJsons = constructResponseList(aiSuccesfulHits);

    VolleyJson response = new VolleyJson(coordJsons);
    JsonNode jsonArgResponse = JsonUtils.serializeRecord(response);
    MessageJson reportdamageResponse = new MessageJson("report-damage", jsonArgResponse);
    JsonNode jsonResponse = JsonUtils.serializeRecord(reportdamageResponse);

    this.out.println(jsonResponse);
  }

  /**
   * Construct a list of coordinates such that each
   * coord is represented by CoordJson
   *
   * @param coords A List of Coordinates
   * @return The List of Coordinates in JsonNode formate
   */
  private List<CoordJson> constructResponseList(List<Coord> coords) {
    List<CoordJson> coordJsons = new ArrayList<>();
    for (Coord c : coords) {
      coordJsons.add(new CoordJson(c.getXpos(), c.getYpos()));
    }
    return coordJsons;
  }

  /**
   * Takes in a list of this player's shots that successfully
   * hit the opponent's ships
   *
   * @param arguments the JsonNode containing the list of shots
   *                  that successfully hit the opponent's ships
   */
  private void handleSuccessfulHits(JsonNode arguments) {
    //will take in a VolleyJson of shots that hit opponents ships
    VolleyJson successfulHits = this.mapper.convertValue(arguments, VolleyJson.class);
    List<Coord> coords = successfulHits.makeCoordList();

    this.aiPlayer.successfulHits(coords);

    MessageJson voidResponse = new MessageJson("successful-hits",
        mapper.createObjectNode());
    JsonNode response = JsonUtils.serializeRecord(voidResponse);


    this.out.println(response);
  }


  /**
   * Reads the JsonNode given by the Server to inform
   * this player the result and reasoning for the game ending
   *
   * @param arguments The JsonNode containing the result and
   *                  reasoning for the game ending
   */
  private void handleEndGame(JsonNode arguments) {
    GameResultJson serverArgs = this.mapper.convertValue(arguments, GameResultJson.class);
    GameResult result = serverArgs.result();
    String reason = serverArgs.reason();

    this.aiPlayer.endGame(result, reason);
    this.out.println(VOID_RESPONSE);
  }

}
