package cs3500.pa04;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa03.model.Coord;
import cs3500.pa04.json.CoordJson;
import cs3500.pa04.json.VolleyJson;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * tests for the VolleyJson Record
 */
class VolleyJsonTest {

  private VolleyJson volley1;

  /**
   * Setup for testing VolleyJson record
   */
  @BeforeEach
  void setup() {
    CoordJson coord1 = new CoordJson(0, 0);
    List<CoordJson> coordJsonList = new ArrayList<>();
    coordJsonList.add(coord1);
    this.volley1 = new VolleyJson(coordJsonList);
  }

  /**
   * tests for the VolleyJson record's makeCoordList() method
   * ensures that the VolleyJson's coordJsons are correctly
   * converted to Coord objects
   */
  @Test
  void testMakeCoordList() {
    List<Coord> actual = this.volley1.makeCoordList();
    List<Coord> expected = new ArrayList<>();
    expected.add(new Coord(0, 0));

    assertEquals(expected, actual);
  }

}