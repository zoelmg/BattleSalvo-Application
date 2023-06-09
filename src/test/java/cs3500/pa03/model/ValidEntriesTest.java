package cs3500.pa03.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * Test the Utility class ValidEntries that determines
 * the validity of manual user's input for BattleSalvo
 */
class ValidEntriesTest {
  Map<ShipType, Integer> exampleDesiredFleets;
  Random seededRandom;

  TwoBoards exampleBoards;

  /**
   * Set up for test methods for Valid Shots
   */
  @BeforeEach
  void setupForValidShots() {
    exampleDesiredFleets = new LinkedHashMap<>();
    exampleDesiredFleets.put(ShipType.CARRIER, 2);
    exampleDesiredFleets.put(ShipType.BATTLESHIP, 0);
    exampleDesiredFleets.put(ShipType.DESTROYER, 0);
    exampleDesiredFleets.put(ShipType.SUBMARINE, 0);

    seededRandom = new Random(10);

    exampleBoards = new TwoBoards(6, 7, exampleDesiredFleets, seededRandom);
    exampleBoards.updateOpponentBoard(new Coord(3, 4), true);
    exampleBoards.updateOpponentBoard(new Coord(5, 4), false);

  }

  /**
   * Test that valid board dimensions will result in true
   * and invalid board dimensions will result in false
   */
  @Test
  void testValidBoardDimensions() {
    assertFalse(ValidEntries.validBoardDimension(5, 5));
    assertFalse(ValidEntries.validBoardDimension(5, 10));
    assertFalse(ValidEntries.validBoardDimension(10, 5));
    assertFalse(ValidEntries.validBoardDimension(16, 16));
    assertFalse(ValidEntries.validBoardDimension(10, 16));
    assertFalse(ValidEntries.validBoardDimension(16, 10));

    assertTrue(ValidEntries.validBoardDimension(12, 12));
  }

  /**
   * Test that valid specification for desired fleet will result in true
   * and invalid specification for desired fleet will result in false
   */
  @Test
  void testValidFleet() {
    Map<ShipType, Integer> ex1 = new LinkedHashMap<>();
    ex1.put(ShipType.CARRIER, 2);
    ex1.put(ShipType.SUBMARINE, 1);
    ex1.put(ShipType.DESTROYER, 1);
    ex1.put(ShipType.BATTLESHIP, 1);
    assertTrue(ValidEntries.validFleet(ex1, 6));

    Map<ShipType, Integer> ex2 = new LinkedHashMap<>();
    ex2.put(ShipType.CARRIER, 0);
    ex2.put(ShipType.SUBMARINE, 0);
    ex2.put(ShipType.DESTROYER, 0);
    ex2.put(ShipType.BATTLESHIP, 0);
    assertFalse(ValidEntries.validFleet(ex2, 6));

    Map<ShipType, Integer> ex3 = new LinkedHashMap<>();
    ex3.put(ShipType.CARRIER, 3);
    ex3.put(ShipType.SUBMARINE, 2);
    ex3.put(ShipType.DESTROYER, 7);
    ex3.put(ShipType.BATTLESHIP, 0);
    assertFalse(ValidEntries.validFleet(ex3, 6));

    Map<ShipType, Integer> ex4 = new LinkedHashMap<>();
    ex3.put(ShipType.CARRIER, 2);
    ex3.put(ShipType.SUBMARINE, 2);
    assertFalse(ValidEntries.validFleet(ex4, 6));
  }

  /**
   * Test that validPlayerShots result in true if the coordinate status is EMPTY
   * and false if the coordinate status is MISS or HIT
   */
  @Test
  void testPlayerShotAlreadyOccupied() {
    Coord validAttempt1 = new Coord(0, 0);
    assertTrue(ValidEntries.validPlayerShot(validAttempt1, exampleBoards));

    Coord validAttempt2 = new Coord(2, 3);
    assertTrue(ValidEntries.validPlayerShot(validAttempt2, exampleBoards));

    Coord invalidAttempt1 = new Coord(3, 4);
    assertFalse(ValidEntries.validPlayerShot(invalidAttempt1, exampleBoards));

    Coord invalidAttempt2 = new Coord(5, 4);
    assertFalse(ValidEntries.validPlayerShot(invalidAttempt2, exampleBoards));


  }

  /**
   * Test that validPlayerShots result in false if the X-value of the coordinate
   * violates any validPlayerShots rule (bigger than board dimension, or negative)
   */
  @Test
  void testPlayerShotInvalidX() {
    Coord invalidAttempt3 = new Coord(-1, 0);
    assertFalse(ValidEntries.validPlayerShot(invalidAttempt3, exampleBoards));

    Coord invalidAttempt5 = new Coord(-1, -2);
    assertFalse(ValidEntries.validPlayerShot(invalidAttempt5, exampleBoards));

    Coord invalidAttempt7 = new Coord(10, 5);
    assertFalse(ValidEntries.validPlayerShot(invalidAttempt7, exampleBoards));
  }


  /**
   * Test that validPlayerShots result in false if the Y-value of the coordinate
   * violates any validPlayerShots rule (bigger than board dimension, or negative)
   */
  @Test
  void testPlayerShotInvalidY() {
    Coord invalidAttempt4 = new Coord(0, -2);
    assertFalse(ValidEntries.validPlayerShot(invalidAttempt4, exampleBoards));


    Coord invalidAttempt6 = new Coord(-1, -2);
    assertFalse(ValidEntries.validPlayerShot(invalidAttempt6, exampleBoards));


    Coord invalidAttempt8 = new Coord(4, 8);
    assertFalse(ValidEntries.validPlayerShot(invalidAttempt8, exampleBoards));
  }
}