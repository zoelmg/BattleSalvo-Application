package cs3500.pa04;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs3500.pa04.client.ProxyDealer;
import cs3500.pa04.json.JsonUtils;
import cs3500.pa04.json.MessageJson;
import cs3500.pa04.json.SetupJson;
import cs3500.pa04.model.AiPlayer;
import cs3500.pa04.model.Ship;
import cs3500.pa04.model.ShipType;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test correct responses for different requests from the socket using a Mock Socket (mocket)
 */
public class ProxyDealerTest {

  private ByteArrayOutputStream testLog;
  private ProxyDealer dealer;
  private final ObjectMapper mapper = new ObjectMapper();


  /**
   * Reset the test log before each test is run.
   */
  @BeforeEach
  public void setup() {
    this.testLog = new ByteArrayOutputStream(2048);
    assertEquals("", logToString());
  }

  /**
   * Check that the server returns a guess when given a hint.
   */
  @Test
  public void testVoidJoinGame() {
    // Prepare sample message
    MessageJson sampleJoinMessage = new MessageJson("join",  mapper.createObjectNode());
    JsonNode sampleJoinMessageJson = JsonUtils.serializeRecord(sampleJoinMessage);

    // Create the client with all necessary messages
    Mocket socket = new Mocket(this.testLog, List.of(sampleJoinMessageJson.toString()));

    // Create a Dealer
    Random random = new Random(10);
    this.dealer = new ProxyDealer(socket, new AiPlayer(random));

    // run the dealer and verify the response
    this.dealer.run();

    String expected = "{\"method-name\":\"join\",\"arguments\""
        + ":{\"name\":\"zoelmg\",\"game-type\":\"SINGLE\"}}\n";
    assertEquals(expected, logToString());
  }

  /**
   * Check that the server returns a guess when given a hint.
   */
  @Test
  public void testVoidSetupGame() {
    Map<ShipType, Integer> exampleSpecs = new LinkedHashMap<>();
    exampleSpecs.put(ShipType.CARRIER, 2);
    exampleSpecs.put(ShipType.BATTLESHIP, 1);
    exampleSpecs.put(ShipType.DESTROYER, 1);
    exampleSpecs.put(ShipType.SUBMARINE, 1);

    SetupJson exampleSetupJson = new SetupJson(6, 8, exampleSpecs);
    JsonNode exampleSetupJsonNode = JsonUtils.serializeRecord(exampleSetupJson);

    // Prepare sample message
    MessageJson sampleJoinMessage = new MessageJson("setup",  exampleSetupJsonNode);
    JsonNode sampleJoinMessageJson = JsonUtils.serializeRecord(sampleJoinMessage);

    // Create the client with all necessary messages
    Mocket socket = new Mocket(this.testLog, List.of(sampleJoinMessageJson.toString()));

    // Create a Dealer
    Random random = new Random(10);
    this.dealer = new ProxyDealer(socket, new AiPlayer(random));

    // run the dealer and verify the response
    this.dealer.run();

    String expected = "{\"method-name\":\"setup\",\"arguments\":{\"fleet\"" +
        ":[{\"coord\":{\"x\":2,\"y\":1},\"length\":6" +
        ",\"direction\":\"VERTICAL\"},{\"coord\":{\"x\":3" +
        ",\"y\":2},\"length\":6,\"direction\":\"VERTICAL\"}" +
        ",{\"coord\":{\"x\":0,\"y\":0},\"length\":5" +
        ",\"direction\":\"VERTICAL\"},{\"coord\":{\"x\":4,\"y\":2},\"length\":4" +
        ",\"direction\":\"VERTICAL\"},{\"coord\":{\"x\":3,\"y\":1},\"length\":3" +
        ",\"direction\":\"HORIZONTAL\"}]}}\n";
    assertEquals(expected, logToString());
  }

  /**
   * Check that the server returns a guess when given a hint.
   */
  @Test
  public void testGuessForHint() {

  }

  /**
   * Converts the ByteArrayOutputStream log to a string in UTF_8 format
   * @return String representing the current log buffer
   */
  private String logToString() {
    return testLog.toString(StandardCharsets.UTF_8);
  }

  /**
   * Try converting the current test log to a string of a certain class.
   *
   * @param classRef Type to try converting the current test stream to.
   * @param <T>      Type to try converting the current test stream to.
   */
  private <T> void responseToClass(@SuppressWarnings("SameParameterValue") Class<T> classRef) {
    try {
      JsonParser jsonParser = new ObjectMapper().createParser(logToString());
      jsonParser.readValueAs(classRef);
      // No error thrown when parsing to a GuessJson, test passes!
    } catch (IOException e) {
      // Could not read
      // -> exception thrown
      // -> test fails since it must have been the wrong type of response.
      fail();
    }
  }

  /**
   * Create a MessageJson for some name and arguments.
   * @param messageName name of the type of message; "hint" or "win"
   * @param messageObject object to embed in a message json
   * @return a MessageJson for the object
   */
  private JsonNode createSampleMessage(String messageName, Record messageObject) {
    MessageJson messageJson = new MessageJson(messageName, JsonUtils.serializeRecord(messageObject));
    return JsonUtils.serializeRecord(messageJson);
  }
}