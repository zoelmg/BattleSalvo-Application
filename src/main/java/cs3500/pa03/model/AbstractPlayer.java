package cs3500.pa03.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Represent an abstract player that contains methods
 * with functionalities common to all players that extends this class
 */
public abstract class AbstractPlayer implements Player {
  /**
   * The name of this player
   */
  protected String name;
  /**
   * This player's board and opponent's board
   * from this player's point of view
   */
  protected TwoBoards boards;
  /**
   * Random that'll will be used for setup or related functionalities
   * that requires random generation
   */
  protected Random random;

  /**
   * Initialize an Abstract player with its name and board
   *
   * @param random a random used for setup of player's boards
   */
  public AbstractPlayer(Random random) {
    this.name = "zoelmg";
    this.boards = null;
    this.random = random;
  }

  /**
   * Get the player's name.
   *
   * @return the player's name
   */
  @Override
  public String name() {
    return this.name;
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
    return boards.getFleet();
  }

  @Override
  public abstract List<Coord> takeShots();

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
   * Notifies the player that the game is over.
   * Win, lose, and draw should all be supported
   *
   * @param result if the player has won, lost, or forced a draw
   * @param reason the reason for the game ending
   */
  @Override
  public void endGame(GameResult result, String reason) {

  }
}
