package cs3500.pa04.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ShipInfoJson(@JsonProperty("CARRIER") int carrier,
                           @JsonProperty("BATTLESHIP") int battleship,
                           @JsonProperty("DESTROYER") int destroyer,
                           @JsonProperty("SUBMARINE") int submarine) {
}
