package cs3500.pa04.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import cs3500.pa04.model.Coord;
import java.util.ArrayList;
import java.util.List;

/**
 * Represent a List of Coordinates in JsonNode format
 *
 * @param shots a list of coordinates/shots
 */
public record VolleyJson(
    @JsonProperty("coordinates") List<CoordJson> shots) {

  /**
   * For each CoordJson in the list of CoordJson,
   * turn into Coord Representation
   *
   * @return a list of Coords
   */
  public List<Coord> makeCoordList() {
    List<Coord> result = new ArrayList<>();
    for (CoordJson c : this.shots) {
      result.add(new Coord(c.xpos(), c.ypos()));
    }
    return result;
  }
}
