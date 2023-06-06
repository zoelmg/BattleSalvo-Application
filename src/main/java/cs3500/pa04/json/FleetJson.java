package cs3500.pa04.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import cs3500.pa04.model.Ship;
import java.util.ArrayList;
import java.util.List;

public record FleetJson(@JsonProperty("fleet") List<ShipJson> fleet) {


}
