package cs3500.pa04.json;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represent Coord as a JsonNode
 *
 * @param xpos the x of a coordinate
 * @param ypos the y of a coordinate
 */
public record CoordJson(
    @JsonProperty("x") int xpos,
    @JsonProperty("y") int ypos) {

}

