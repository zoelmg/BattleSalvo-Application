package cs3500.pa04.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Represent a computer player that will
 * play BattleSalvo
 */
public class AiPlayer extends AbstractPlayer {

  /**
   * Initialize the AI player with a random
   *
   * @param random the random that will be used generate random coordinates
   */
  public AiPlayer(Random random) {
    super(random);
  }

  /**
   * Generate a list of random coordinates that the Ai player will use
   *
   * @return The list of coordinates the AI player would like to take shot to
   */
  @Override
  public List<Coord> takeShots() {
    List<Coord> shots = new ArrayList<>();
    int shotsAvailable = boards.howManyShotsAvailable();

    do {
      int randomIndex = random.nextInt(boards.getRemainingOpCoord().size());
      shots.add(boards.getRemainingOpCoord().get(randomIndex));
      boards.getRemainingOpCoord().remove(randomIndex);
    } while (shots.size() != shotsAvailable);

    return shots;
  }
}
