package cs3500.pa03.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;


/**
 * Test methods of Coord class
 */
public class CoordTest {
  /**
   * Check that if a coordinate have the same
   * x and y on a board, then they are the same coordinate
   */
  @Test
  void testCoordEqual() {
    Coord coord1 = new Coord(5, 6);
    Coord coord2 = new Coord(5, 6);

    //equality with an equal object
    assertEquals(coord1, coord2);
    assertEquals(coord2, coord1);
    assertEquals(coord1, coord1);

    Coord coord3 = new Coord(3, 4);
    //inequality with a different object
    assertNotEquals(coord1, coord3);
    assertNotEquals(coord3, coord1);

    //invalid input
    assertNotEquals(null, coord1);
    assertNotEquals("some string", coord1);
  }

  /**
   * Test that the correct string is outputted
   * for respective coord status
   */
  @Test
  void testCoordStatusAsString() {
    Coord coord1 = new Coord(5, 6);
    coord1.setStatus(CoordStatus.HIT);
    assertEquals(" H ", coord1.coordStatusAsString());

    Coord coord2 = new Coord(8, 9);
    coord2.setStatus(CoordStatus.MISS);
    assertEquals(" M ", coord2.coordStatusAsString());

    Coord coord3 = new Coord(3, 4);
    coord3.setStatus(CoordStatus.CARRIER);
    assertEquals(" C ", coord3.coordStatusAsString());

    Coord coord4 = new Coord(1, 2);
    coord4.setStatus(CoordStatus.EMPTY);
    assertEquals(" O ", coord4.coordStatusAsString());

  }
}
