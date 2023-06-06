package cs3500.pa04.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CoordJson (
  @JsonProperty("x") int xpos,
  @JsonProperty("y") int ypos) {

}

