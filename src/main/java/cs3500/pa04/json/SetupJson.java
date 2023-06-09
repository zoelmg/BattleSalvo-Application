package cs3500.pa04.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import cs3500.pa03.model.ShipType;
import java.util.Map;

/**
 * Represent the specification of setting up the boards
 * and fleet of the player in JsonNode format
 *
 * @param width the width of the board
 * @param height the height of the board
 * @param fleetSpec the specification for the fleet
 */
public record SetupJson(
    @JsonProperty("width") int width,
    @JsonProperty("height") int height,
    @JsonProperty("fleet-spec") Map<ShipType, Integer> fleetSpec) {
}
