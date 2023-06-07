package cs3500.pa04.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import cs3500.pa04.model.GameResult;

/**
 * Represent GameResult in the format of JsonNode
 *
 * @param result the result of the game
 * @param reason the reasoning for the result
 */
public record GameResultJson(
    @JsonProperty("result") GameResult result,
    @JsonProperty("reason") String reason) {
}
