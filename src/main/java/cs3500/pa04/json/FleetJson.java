package cs3500.pa04.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * Represent a Fleet (a list of ships) in format of Json
 *
 * @param fleet a list of ships
 */
public record FleetJson(
    @JsonProperty("fleet") List<ShipJson> fleet) {

}
