package cs3500.pa04.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PlayerJson(
    @JsonProperty("name") String playerName,
    @JsonProperty("game-type") GameType gameType) {
}
