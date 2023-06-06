package cs3500.pa04.client;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs3500.pa04.controller.Controller;
import cs3500.pa04.json.CoordJson;
import cs3500.pa04.json.JsonUtils;
import cs3500.pa04.json.MessageJson;
import cs3500.pa04.json.VolleyJson;
import cs3500.pa04.model.Coord;
import cs3500.pa04.model.Player;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.constant.Constable;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

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
      handleJoin(arguments);
    } else if ("setup".equals(name)) {
      handleSetup(arguments);
    } else if ("take-shots".equals(name)) {
      handleTakeShots(arguments);
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

  private void handleJoin(JsonNode arguments) {
    //will require a PlayerInfo object to return response to server
  }

  private void handleSetup(JsonNode arguments) {
    //will require a SetupJson or some sort of object to take in server input
    //will return a FleetJson to server
  }

  private void handleTakeShots(JsonNode arguments) {

    List<Coord> shots = this.aiPlayer.takeShots();
    List<CoordJson> coordJsons = new ArrayList<>();
    for (Coord c : shots) {
      coordJsons.add(new CoordJson(c.getXpos(), c.getYpos()));
    }

    VolleyJson response = new VolleyJson(coordJsons);
    JsonNode jsonResponse = JsonUtils.serializeRecord(response);
    this.out.println(jsonResponse);
  }

  private void handleReportDamage(JsonNode arguments) {
    //will take in a VolleyJson of shots fired on this player's board
    //will return a VolleyJson of shots that hit this player's ships to server
  }

  private void handleSuccessfulHits(JsonNode arguments) {
    //will take in a VolleyJson of shots that hit opponents ships
    //no added info in return to server
  }

  private void handleEndGame(JsonNode arguments) {
    //will require an EndJson to take in "result" and "reason" arguments from server
    //no added info in return to server
  }

}
