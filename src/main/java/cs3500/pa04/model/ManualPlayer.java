package cs3500.pa04.model;

import cs3500.pa04.view.View;
import java.util.List;
import java.util.Random;

/**
 * Represents a Manual Player in the game of BattleSalvo
 */
public class ManualPlayer extends AbstractPlayer {
  private View userEntry;

  /**
   * Initialize a Manual Player
   *
   * @param random    a random used to set up this player's board
   * @param userEntry a view so that the user are allowed to input their desired shots
   */
  public ManualPlayer(Random random, View userEntry) {
    super(random);
    this.userEntry = userEntry;
  }

  /**
   * Ask the manual player to select their shots for the next round
   * and return their shots as a list of coordinate
   *
   * @return a list of valid shots that the player would like to make
   */
  @Override
  public List<Coord> takeShots() {
    int shotsAvailable = this.boards.howManyShotsAvailable();
    List<Coord> mostRecentAttempt;
    do {
      mostRecentAttempt = this.userEntry.showBoard(this.boards);

    } while (!allUserShotsAreValid(mostRecentAttempt));

    for (Coord currCoord : mostRecentAttempt) {
      this.boards.updateOpponentBoard(currCoord, false);
    }
    return mostRecentAttempt;
  }

  /**
   * Helps determine if all chosen shots are valid
   *
   * @param shots a list of shots that the manual user selected
   * @return if all shots are valid shots
   */
  private boolean allUserShotsAreValid(List<Coord> shots) {
    for (Coord coord : shots) {
      if (!ValidEntries.validPlayerShot(coord, this.boards)) {
        return false;
      }
    }
    return true;
  }
}
