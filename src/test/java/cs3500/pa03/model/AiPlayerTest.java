package cs3500.pa03.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa04.model.AiPlayer;
import cs3500.pa04.model.Coord;
import cs3500.pa04.model.Player;
import cs3500.pa04.model.ShipType;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * Tests to check methods of AiPlayer
 */
class AiPlayerTest {
  Random exampleRandom;
  Player exampleAi;

  Map<ShipType, Integer> exampleDesiredFleets;

  /**
   * Set up for an AiPlayer
   */
  @BeforeEach
  void setupAiPlayer() {

    exampleRandom = new Random(10);
    exampleAi = new AiPlayer(exampleRandom);

    exampleDesiredFleets = new LinkedHashMap<>();
    exampleDesiredFleets.put(ShipType.CARRIER, 3);
    exampleDesiredFleets.put(ShipType.BATTLESHIP, 0);
    exampleDesiredFleets.put(ShipType.DESTROYER, 0);
    exampleDesiredFleets.put(ShipType.SUBMARINE, 0);
    exampleAi.setup(6, 6, exampleDesiredFleets);
  }

  /**
   * Test that the AiPlayer is generating coordinates
   */
  @Test
  void testTakeShots() {
    List<Coord> exampleCoords;

    exampleCoords = exampleAi.takeShots();
    assertEquals(3, exampleCoords.size());
  }

}