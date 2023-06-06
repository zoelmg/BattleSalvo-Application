package cs3500.pa04.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public record ShipJson(
    @JsonProperty("coord") List<CoordJson> loCoordJson,
    @JsonProperty("length") int length,
    @JsonProperty("direction") ShipDirection direction) {
}
