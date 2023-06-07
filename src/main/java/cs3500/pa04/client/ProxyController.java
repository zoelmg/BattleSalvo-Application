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
import cs3500.pa04.model.ShipType;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ProxyController implements Controller {
  private final Socket server;
  private final Player aiPlayer;
  private final InputStream in;

  //private final OutputStream out; // is a PrintStream as per Lab06
  private final PrintStream out;
  private final ObjectMapper mapper = new ObjectMapper();
  private static final JsonNode VOID_RESPONSE =
      new ObjectMapper().getNodeFactory().textNode("void");

  public ProxyController(Socket server, Player aiPlayer) throws IOException {
    this.server = server;
    this.aiPlayer = aiPlayer;
    this.in = server.getInputStream();
    //this.out = server.getOutputStream();
    this.out = new PrintStream(server.getOutputStream()); //as per Lab06
  }


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

    if ("join".equals(name)) {
      handleJoin();
    } else if ("setup".equals(name)) {
      handleSetup(arguments);
    } else if ("take-shots".equals(name)) {
      handleTakeShots();
    } else if ("report-damage".equals(name)) {
      handleReportDamage(arguments);
    } else if ("successful-hits".equals(name)) {
      handleSuccessfulHits(arguments);
    } else if ("end-game".equals(name)) {
      handleEndGame(arguments);
    } else {
      throw new IllegalStateException("Invalid message name");
    }
  }

  private void handleJoin() {
    PlayerJson response = new PlayerJson(this.aiPlayer.name(), GameType.SINGLE);

    JsonNode jsonArgResponse = JsonUtils.serializeRecord(response);
    MessageJson joinResponse = new MessageJson("join", jsonArgResponse);
    JsonNode jsonResponse = JsonUtils.serializeRecord(joinResponse);
    this.out.println(jsonResponse);
  }

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



  private void handleTakeShots() {
    List<Coord> shots = this.aiPlayer.takeShots();
    List<CoordJson> coordJsons = new ArrayList<>();
    for (Coord c : shots) {
      coordJsons.add(new CoordJson(c.getXpos(), c.getYpos()));
    }

    VolleyJson response = new VolleyJson(coordJsons);
    JsonNode jsonArgResponse = JsonUtils.serializeRecord(response);
    MessageJson takeshotsResponse = new MessageJson("take-shots", jsonArgResponse);
    JsonNode jsonResponse = JsonUtils.serializeRecord(takeshotsResponse);
    this.out.println(jsonResponse);
  }



  private void handleReportDamage(JsonNode arguments) {
    VolleyJson opponentShots = this.mapper.convertValue(arguments, VolleyJson.class);
    List<Coord> coords = opponentShots.makeCoordList();

    List<Coord> aiSuccesfulHits = this.aiPlayer.reportDamage(coords);

    List<CoordJson> coordJsons = new ArrayList<>();
    for (Coord c : aiSuccesfulHits) {
      coordJsons.add(new CoordJson(c.getXpos(), c.getYpos()));
    }

    VolleyJson response = new VolleyJson(coordJsons);
    JsonNode jsonArgResponse = JsonUtils.serializeRecord(response);
    MessageJson reportdamageResponse = new MessageJson("report-damage", jsonArgResponse);
    JsonNode jsonResponse = JsonUtils.serializeRecord(reportdamageResponse);
    this.out.println(jsonResponse);
  }

  private void handleSuccessfulHits(JsonNode arguments) {
    //will take in a VolleyJson of shots that hit opponents ships
    VolleyJson successfulHits = this.mapper.convertValue(arguments, VolleyJson.class);
    List<Coord> coords = successfulHits.makeCoordList();

    this.aiPlayer.successfulHits(coords);

    //no added info in return to server
    this.out.println(VOID_RESPONSE); //Is this the correct way to return nothing?!
  }

  private void handleEndGame(JsonNode arguments) {
    GameResultJson serverArgs = this.mapper.convertValue(arguments, GameResultJson.class);
    GameResult result = serverArgs.result();
    String reason = serverArgs.reason();

    this.aiPlayer.endGame(result, reason);
    this.out.println(VOID_RESPONSE); //Is this the correct way to return nothing?!
  }

}
