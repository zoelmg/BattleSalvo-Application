package cs3500.pa04.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import cs3500.pa04.model.Coord;
import java.util.ArrayList;
import java.util.List;

public record VolleyJson(

    @JsonProperty("coordinates") List<CoordJson> shots) {

  public List<Coord> makeCoordList() {
    List<Coord> result = new ArrayList<>();
    for (CoordJson c : this.shots) {
      result.add(new Coord(c.xpos(), c.ypos()));
    }
    return result;
  }

  public static List<CoordJson> makeCoordJsonList(List<Coord> coords) {
    List<CoordJson> result = new ArrayList<>();
    for (Coord c : coords) {
      result.add(new CoordJson(c.getXpos(), c.getYpos()));
    }
    return result;
  }

}
