package cs3500.pa03.model;

import cs3500.pa03.view.View;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Represents a Manual Player in the game of BattleSalvo
 */
public class ManualPlayer extends AbstractPlayer {
  private final View userEntry;

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
   * Given the specifications for a BattleSalvo board, return a list of ships with their locations
   * on the board.
   *
   * @param height         the height of the board, range: [6, 15] inclusive
   * @param width          the width of the board, range: [6, 15] inclusive
   * @param specifications a map of ship type to the number of occurrences each ship should
   *                       appear on the board
   * @return the placements of each ship on the board
   */
  @Override
  public List<Ship> setup(int height, int width, Map<ShipType, Integer> specifications) {
    this.boards = new TwoBoards(height, width, specifications, random);
    this.height = height;
    this.width = width;
    return boards.getFleet();
  }


  /**
   * Ask the manual player to select their shots for the next round
   * and return their shots as a list of coordinate
   *
   * @return a list of valid shots that the player would like to make
   */
  @Override
  public List<Coord> takeShots() {
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
   * Given the list of shots the opponent has fired on this player's board, report which
   * shots hit a ship on this player's board.
   *
   * @param opponentShotsOnBoard the opponent's shots on this player's board
   * @return a filtered list of the given shots that contain all locations of shots that hit a
   *         ship on this board
   */
  @Override
  public List<Coord> reportDamage(List<Coord> opponentShotsOnBoard) {
    List<Coord> damagedCoords = new ArrayList<>();
    for (Coord currCoord : opponentShotsOnBoard) {
      if (boards.updateMyBoard(currCoord)) {
        damagedCoords.add(currCoord);
      }
    }

    this.boards.updateRemainingShips();
    return damagedCoords;
  }


  /**
   * Reports to this player what shots in their previous volley returned from takeShots()
   * successfully hit an opponent's ship.
   *
   * @param shotsThatHitOpponentShips the list of shots that successfully hit the opponent's ships
   */
  @Override
  public void successfulHits(List<Coord> shotsThatHitOpponentShips) {
    for (Coord currCoord : shotsThatHitOpponentShips) {
      boards.updateOpponentBoard(currCoord, true);
    }
  }

  /**
   * Helps determine if all chosen shots are valid
   *
   * @param shots a list of shots that the manual user selected
   * @return if all shots are valid shots
   */
  private boolean allUserShotsAreValid(List<Coord> shots) {
    for (Coord coord : shots) {
      if (!ValidEntries.validPlayerShot(coord, this.boards, shots)) {
        return false;
      }
    }
    return true;
  }
}
