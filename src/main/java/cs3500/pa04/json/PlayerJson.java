package cs3500.pa04.json;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represent the Player in JsonNode
 *
 * @param playerName the name of the Player
 * @param gameType what GameType the Player would like to join
 */
public record PlayerJson(
    @JsonProperty("name") String playerName,
    @JsonProperty("game-type") GameType gameType) {
}
