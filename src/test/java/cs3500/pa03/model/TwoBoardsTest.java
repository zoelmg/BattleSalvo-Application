package cs3500.pa03.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa04.model.Coord;
import cs3500.pa04.model.CoordStatus;
import cs3500.pa04.model.ShipType;
import cs3500.pa04.model.TwoBoards;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * Test for methods of TwoBoard class
 */
class TwoBoardsTest {
  Map<ShipType, Integer> exampleDesiredFleets;
  Random seededRandom;

  TwoBoards exampleBoards;

  @BeforeEach
  void setupBoard() {
    exampleDesiredFleets = new LinkedHashMap<>();
    exampleDesiredFleets.put(ShipType.CARRIER, 3);
    exampleDesiredFleets.put(ShipType.BATTLESHIP, 0);
    exampleDesiredFleets.put(ShipType.DESTROYER, 0);
    exampleDesiredFleets.put(ShipType.SUBMARINE, 0);

    seededRandom = new Random(10);

    exampleBoards = new TwoBoards(6, 6, exampleDesiredFleets, seededRandom);
    exampleBoards.updateOpponentBoard(new Coord(3, 4), true);
    exampleBoards.updateOpponentBoard(new Coord(5, 4), false);
  }

  /**
   * Tests for determining how many shots are available,
   * if there are more coordinate than the ships, then the fleet size
   * if there are more ships than coordinates, then coordinate amount
   */
  @Test
  void testHowManyShotsAvailable() {
    //when the board only has one MISS and one HIT coordinate,
    //return will be the fleet size
    assertEquals(3, exampleBoards.howManyShotsAvailable());

    //set all coordinates except 1 (coordinate 5, 5) to MISS
    List<Coord> onlyKeep = new ArrayList<>(List.of(new Coord(5, 5)));
    exampleBoards.getRemainingOpCoord().retainAll(onlyKeep);

    //now the board should return 1 instead of 3 available shots
    assertEquals(1, exampleBoards.howManyShotsAvailable());
  }

  /**
   * Test that updating my board will result in status
   * change of the respective coordinate
   */
  @Test
  void updateMyBoard() {

    //check that the original coord status before method call is EMPTY or PRESENT
    assertEquals(CoordStatus.EMPTY, exampleBoards.getMyBoard()[2][2].getStatus());
    assertEquals(CoordStatus.CARRIER, exampleBoards.getMyBoard()[0][0].getStatus());

    //call the methods to change coordinate status
    //Note: x and y are reversed because for 2D array Y goes first and X goes second
    exampleBoards.updateMyBoard(new Coord(2, 2));
    exampleBoards.updateMyBoard(new Coord(0, 0));


    //check that now the status has changed to HIT or MiSS
    assertEquals(CoordStatus.MISS, exampleBoards.getMyBoard()[2][2].getStatus());
    assertEquals(CoordStatus.HIT, exampleBoards.getMyBoard()[0][0].getStatus());

  }

  /**
   * Test that the updateRemainingShips method are removing ships
   * from fleet at the correct time
   */
  @Test
  void testUpdateRemainingShips() {
    //check that the original fleet size is 3
    assertEquals(3, exampleBoards.getFleet().size());

    //hit one coordinate of one ship, which means the size of the fleet
    //should still be 3
    exampleBoards.updateMyBoard(new Coord(0, 0));
    exampleBoards.updateRemainingShips();
    assertEquals(3, exampleBoards.getFleet().size());

    //hit all coordinates of that ship
    exampleBoards.updateMyBoard(new Coord(0, 1));
    exampleBoards.updateMyBoard(new Coord(0, 2));
    exampleBoards.updateMyBoard(new Coord(0, 3));
    exampleBoards.updateMyBoard(new Coord(0, 4));
    exampleBoards.updateMyBoard(new Coord(0, 5));
    exampleBoards.updateRemainingShips();

    //now check the size of the ship has gone down to 2
    assertEquals(2, exampleBoards.getFleet().size());

  }
}