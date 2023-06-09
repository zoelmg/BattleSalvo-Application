package cs3500.pa03.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * Tests for methods of AbstractPlayer class that performs
 * functionality of updating status of the game
 */
class AbstractPlayerTest {
  Random exampleRandom;
  AbstractPlayer examplePlayer;
  Map<ShipType, Integer> exampleDesiredFleets;
  List<Coord> exampleList;

  /**
   * Set up for an Abstract Player
   */
  @BeforeEach
  void setupAbstractPlayer() {
    exampleRandom = new Random(10);
    examplePlayer = new AiPlayer(exampleRandom);

    exampleDesiredFleets = new LinkedHashMap<>();
    exampleDesiredFleets.put(ShipType.CARRIER, 3);
    exampleDesiredFleets.put(ShipType.BATTLESHIP, 0);
    exampleDesiredFleets.put(ShipType.DESTROYER, 0);
    exampleDesiredFleets.put(ShipType.SUBMARINE, 0);
    examplePlayer.setup(6, 6, exampleDesiredFleets);


    exampleList = new ArrayList<>(Arrays.asList(new Coord(0, 0),
        new Coord(1, 0), new Coord(2, 2), new Coord(0, 2)));
  }

  /**
   * Test that name method is correct
   */
  @Test
  void testName() {
    assertEquals("zoelmg", examplePlayer.name());
  }

  /**
   * Test the method ReportDamage to see if the method correctly
   * filters out the missed coordinates
   */
  @Test
  void testReportDamage() {

    List<Coord> filteredExampleList = examplePlayer.reportDamage(exampleList);
    assertEquals(2, filteredExampleList.size());
    assertEquals(0, filteredExampleList.get(0).getXpos());
    assertEquals(0, filteredExampleList.get(0).getYpos());
    assertEquals(0, filteredExampleList.get(1).getXpos());
    assertEquals(2, filteredExampleList.get(1).getYpos());
  }

  /**
   * Test the method SuccessfulHits and check the method correctly
   * updates the status of opponent's board to HIT
   */
  @Test
  void testSuccessfulHits() {
    //In 2D arrays, Y Comes first and X comes later
    examplePlayer.successfulHits(exampleList);
    assertEquals(" H ", examplePlayer.boards.getOpBoard()[0][0].coordStatusAsString());
    assertEquals(" H ", examplePlayer.boards.getOpBoard()[0][1].coordStatusAsString());
    assertEquals(" H ", examplePlayer.boards.getOpBoard()[2][2].coordStatusAsString());
    assertEquals(" H ", examplePlayer.boards.getOpBoard()[2][0].coordStatusAsString());

  }

}