package cs3500.pa04;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs3500.pa03.model.AiPlayer;
import cs3500.pa03.model.Coord;
import cs3500.pa03.model.GameResult;
import cs3500.pa03.model.Player;
import cs3500.pa03.model.ShipType;
import cs3500.pa04.client.ProxyController;
import cs3500.pa04.json.CoordJson;
import cs3500.pa04.json.GameResultJson;
import cs3500.pa04.json.JsonUtils;
import cs3500.pa04.json.MessageJson;
import cs3500.pa04.json.SetupJson;
import cs3500.pa04.json.VolleyJson;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test correct responses for different requests from the socket using a Mock Socket (mocket)
 */
public class ProxyControllerTest {

  private ByteArrayOutputStream testLog;
  private ProxyController dealer;
  private final ObjectMapper mapper = new ObjectMapper();
  private final Random random = new Random(10);
  private final Map<ShipType, Integer> exampleSpecs = new LinkedHashMap<>();
  private final Player aiPlayer = new AiPlayer(random);


  /**
   * Reset the test log before each test is run.
   */
  @BeforeEach
  void setup() {
    this.testLog = new ByteArrayOutputStream(2048);
    assertEquals("", logToString());

    exampleSpecs.put(ShipType.CARRIER, 2);
    exampleSpecs.put(ShipType.BATTLESHIP, 1);
    exampleSpecs.put(ShipType.DESTROYER, 1);
    exampleSpecs.put(ShipType.SUBMARINE, 1);
  }

  /**
   * Check that the server returns a guess when given a hint.
   */
  @Test
  void testVoidJoinGame() {
    // Prepare sample message
    MessageJson sampleJoinMessage = new MessageJson("join",  mapper.createObjectNode());
    JsonNode sampleJoinMessageJson = JsonUtils.serializeRecord(sampleJoinMessage);

    // Create the client with all necessary messages
    Mocket socket = new Mocket(this.testLog, List.of(sampleJoinMessageJson.toString()));

    // Create a Dealer
    this.dealer = new ProxyController(socket, aiPlayer);

    // run the dealer and verify the response
    this.dealer.run();

    String expected = "{\"method-name\":\"join\",\"arguments\""
        + ":{\"name\":\"zoelmg\",\"game-type\":\"SINGLE\"}}\n";
    assertEquals(expected, logToString());
  }

  /**
   * Check that the Ai player returns a fleet
   */
  @Test
  void testVoidSetupGame() {

    SetupJson exampleSetupJson = new SetupJson(6, 8, exampleSpecs);
    JsonNode exampleSetupJsonNode = JsonUtils.serializeRecord(exampleSetupJson);

    // Prepare sample message
    MessageJson sampleSetupMessage = new MessageJson("setup",  exampleSetupJsonNode);
    JsonNode sampleSetupMessageJson = JsonUtils.serializeRecord(sampleSetupMessage);

    // Create the client with all necessary messages
    Mocket socket = new Mocket(this.testLog, List.of(sampleSetupMessageJson.toString()));

    // Create a Dealer
    this.dealer = new ProxyController(socket, aiPlayer);

    // run the dealer and verify the response
    this.dealer.run();

    String expected = "{\"method-name\":\"setup\",\"arguments\":{\"fleet\""
        + ":[{\"coord\":{\"x\":2,\"y\":1},\"length\":6"
        + ",\"direction\":\"VERTICAL\"},{\"coord\":{\"x\":3"
        + ",\"y\":2},\"length\":6,\"direction\":\"VERTICAL\"}"
        + ",{\"coord\":{\"x\":0,\"y\":0},\"length\":5"
        + ",\"direction\":\"VERTICAL\"},{\"coord\":{\"x\":4,\"y\":2},\"length\":4"
        + ",\"direction\":\"VERTICAL\"},{\"coord\":{\"x\":3,\"y\":1},\"length\":3"
        + ",\"direction\":\"HORIZONTAL\"}]}}\n";
    assertEquals(expected, logToString());
  }

  /**
   * Check that the Ai player returns a volley
   * after take shot is being called by the server
   */
  @Test
  void testTakeShots() {
    // Prepare sample message
    MessageJson sampleTakeShotMessage = new MessageJson("take-shots", mapper.createObjectNode());
    JsonNode sampleTakeShotMessageJson = JsonUtils.serializeRecord(sampleTakeShotMessage);

    // Create the client with all necessary messages
    Mocket socket = new Mocket(this.testLog, List.of(sampleTakeShotMessageJson.toString()));

    // Create a Dealer
    this.dealer = new ProxyController(socket, aiPlayer);

    aiPlayer.setup(6, 8, exampleSpecs);

    // run the dealer and verify the response
    this.dealer.run();

    String expected = "{\"method-name\":\"take-shots\",\"arguments\":"
        + "{\"coordinates\":[{\"x\":5,\"y\":2},{\"x\":5,\"y\":1},"
        + "{\"x\":3,\"y\":5},{\"x\":7,\"y\":3},{\"x\":3,\"y\":0}]}}\n";
    assertEquals(expected, logToString());
  }

  /**
   * Check that the Ai player returns a volley
   * after Report Damage is processed
   */
  @Test
  void testReportDamage() {
    List<Coord> mockShots = new ArrayList<>(Arrays.asList(new Coord(0, 0),
        new Coord(4, 4), new Coord(3, 2), new Coord(2, 1)));
    // Prepare sample message

    List<CoordJson> mockShotsJson = new ArrayList<>();
    for (Coord c : mockShots) {
      mockShotsJson.add(new CoordJson(c.getXpos(), c.getYpos()));
    }

    VolleyJson sampleVolley = new VolleyJson(mockShotsJson);
    JsonNode sampleVolleyJsonNode = JsonUtils.serializeRecord(sampleVolley);
    MessageJson sampleReportDamageMessage = new MessageJson("report-damage",
        sampleVolleyJsonNode);
    JsonNode sampleReportDamageMessageJson = JsonUtils.serializeRecord(sampleReportDamageMessage);

    // Create the client with all necessary messages
    Mocket socket = new Mocket(this.testLog, List.of(sampleReportDamageMessageJson.toString()));
    this.dealer = new ProxyController(socket, aiPlayer);
    aiPlayer.setup(6, 8, exampleSpecs);

    // run the dealer and verify the response
    this.dealer.run();

    String expected = "{\"method-name\":\"report-damage\",\"arguments\":{\"coordinates\":"
        + "[{\"x\":4,\"y\":4},{\"x\":2,\"y\":1}]}}\n";
    assertEquals(expected, logToString());
  }


  /**
   * Check that the Ai player returns the
   * successful hit message json after successful hits
   */
  @Test
  void testSuccessfulHits() {
    List<Coord> mockShots = new ArrayList<>(Arrays.asList(new Coord(4, 3),
        new Coord(6, 4), new Coord(2, 0), new Coord(2, 1)));

    // Prepare sample message
    List<CoordJson> mockShotsJson = new ArrayList<>();
    for (Coord c : mockShots) {
      mockShotsJson.add(new CoordJson(c.getXpos(), c.getYpos()));
    }

    VolleyJson sampleVolley = new VolleyJson(mockShotsJson);
    JsonNode sampleVolleyJsonNode = JsonUtils.serializeRecord(sampleVolley);
    MessageJson sampleSuccessfulHitMessage = new MessageJson("successful-hits",
        sampleVolleyJsonNode);
    JsonNode sampleSuccessfulHitMessageJson = JsonUtils.serializeRecord(sampleSuccessfulHitMessage);

    // Create the client with all necessary messages
    Mocket socket = new Mocket(this.testLog, List.of(sampleSuccessfulHitMessageJson.toString()));
    this.dealer = new ProxyController(socket, aiPlayer);
    aiPlayer.setup(6, 8, exampleSpecs);

    // run the dealer and verify the response
    this.dealer.run();

    String expected = "{\"method-name\":\"successful-hits\",\"arguments\":{}}\n";
    assertEquals(expected, logToString());
  }

  /**
   * Converts the ByteArrayOutputStream log to a string in UTF_8 format
   *
   * @return String representing the current log buffer
   */
  private String logToString() {
    return testLog.toString(StandardCharsets.UTF_8);
  }

  /**
   * Tests the ProxyController's handleEndGame() method.
   */
  @Test
  void testEndGame() {
    GameResultJson sampleResult = new GameResultJson(GameResult.WIN, "You Sank Their Ships");
    JsonNode sampleResultJsonNode = JsonUtils.serializeRecord(sampleResult);
    MessageJson sampleEndGameMessage = new MessageJson("end-game", sampleResultJsonNode);
    JsonNode sampleEndGameMessageJson = JsonUtils.serializeRecord(sampleEndGameMessage);

    // Create the client with all necessary messages
    Mocket socket = new Mocket(this.testLog, List.of(sampleEndGameMessageJson.toString()));
    this.dealer = new ProxyController(socket, aiPlayer);

    // run the dealer and verify the response
    this.dealer.run();

    String expected = "{\"method-name\":\"end-game\",\"arguments\":{}}\n";
    assertEquals(expected, logToString());
  }

}