package cs3500.pa04.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * Represent the message that the Server is sending as a JsonNode
 *
 * @param methodCall the method calls that the Server would like the player to do
 * @param arguments the arguments for those method calls
 */
public record MessageJson(
    @JsonProperty("method-name") String methodCall,
    @JsonProperty("arguments") JsonNode arguments) {
}
