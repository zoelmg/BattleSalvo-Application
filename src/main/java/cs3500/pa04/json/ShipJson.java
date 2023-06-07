package cs3500.pa04.json;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represent a Ship in the JsonNode format
 *
 * @param head the head coordinate of the ship
 * @param length the number of coordinates this ship occupies
 * @param direction the direction of the ship on the board
 */
public record ShipJson(
    @JsonProperty("coord") CoordJson head,
    @JsonProperty("length") int length,
    @JsonProperty("direction") ShipDirection direction) {
}
