package cs3500.pa04.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SetupJson(
    @JsonProperty("width") int width,
    @JsonProperty("height") int height,
    @JsonProperty("fleet-spec") ShipInfoJson fleetSpec) {
}
