package cs3500.pa03.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa03.view.SingleManualPlayerView;
import cs3500.pa03.view.View;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



/**
 * Test methods of Manual Player class
 */
class ManualPlayerTest {
  Appendable exampleOut;
  Readable exampleIn;
  Scanner exampleScan;
  View exampleView;
  Random seededRandom;
  AbstractPlayer examplePlayer;
  String message;
  LinkedHashMap<ShipType, Integer> exampleDesiredFleets;
  List<Coord> exampleList;

  /**
   * Setup for testing TakeShots
   */
  @BeforeEach
  void setupTakeShots() {
    seededRandom = new Random(10);
    exampleOut = new StringBuilder();
    message = "0 0 1 0 3 4\n"
      + "0 0 1 1 2 1\n"
      + "5 5 5 4 5 3";
    exampleIn = new StringReader(message);
    exampleScan = new Scanner(exampleIn);
    exampleView = new SingleManualPlayerView(exampleScan, exampleOut);
    examplePlayer = new ManualPlayer(seededRandom, exampleView);

    exampleDesiredFleets = new LinkedHashMap<>();
    exampleDesiredFleets.put(ShipType.CARRIER, 3);
    exampleDesiredFleets.put(ShipType.BATTLESHIP, 0);
    exampleDesiredFleets.put(ShipType.DESTROYER, 0);
    exampleDesiredFleets.put(ShipType.SUBMARINE, 0);
    examplePlayer.setup(6, 6, exampleDesiredFleets);

    exampleList = new ArrayList<>(Arrays.asList(new Coord(0, 0), new Coord(1, 0),
      new Coord(3, 5)));
  }

  /**
   * Test valid inputted coordinate
   */
  @Test
  void testValidTakeShots() {
    List<Coord> shotTaken = examplePlayer.takeShots();

    assertEquals(0, shotTaken.get(0).getXpos());
    assertEquals(0, shotTaken.get(0).getYpos());
    assertEquals(1, shotTaken.get(1).getXpos());
    assertEquals(0, shotTaken.get(1).getYpos());
    assertEquals(3, shotTaken.get(2).getXpos());
    assertEquals(4, shotTaken.get(2).getYpos());

  }

  /**
   * Test invalid inputted coordinates
   * Take shots ignore the second input line in message because 0 0 was already
   * hit, so shot taken is returning the third input line
   */
  @Test
  void testInvalidTakeShots() {
    List<Coord> shotTaken = examplePlayer.takeShots();
    assertEquals(3, shotTaken.size());

    shotTaken = examplePlayer.takeShots();
    assertEquals(5, shotTaken.get(0).getXpos());
    assertEquals(5, shotTaken.get(0).getYpos());
    assertEquals(5, shotTaken.get(1).getXpos());
    assertEquals(4, shotTaken.get(1).getYpos());
    assertEquals(5, shotTaken.get(2).getXpos());
    assertEquals(3, shotTaken.get(2).getYpos());

  }

}