package cs3500.pa04.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import cs3500.pa04.model.GameResult;

public record GameResultJson(@JsonProperty("result") GameResult result,
                             @JsonProperty("reason") String reason) {
}
