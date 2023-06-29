package cs3500.pa03.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Represent a computer player that will
 * play BattleSalvo
 */
public class AiPlayer extends AbstractPlayer {
  private final List<Coord> masterShots;
  private final List<Coord> allFiredShots;

  /**
   * Initialize the AI player with a random
   *
   * @param random the random that will be used generate random coordinates
   */
  public AiPlayer(Random random) {
    super(random);
    this.masterShots = new ArrayList<>();
    this.allFiredShots = new ArrayList<>();
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
    createMasterShotList(height, width);
    return boards.getFleet();
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

    if (!(shotsAvailable == 0)) {
      do {
        try {
          Coord nextShot = this.masterShots.get(0);
          shots.add(nextShot);
          allFiredShots.add(nextShot);
          boards.getRemainingOpCoord().remove(nextShot);
          this.masterShots.remove(nextShot);
        } catch (IndexOutOfBoundsException err) {
          int randIndex = random.nextInt(boards.getRemainingOpCoord().size());
          Coord nextShot = this.boards.getRemainingOpCoord().get(randIndex);
          if (!allFiredShots.contains(nextShot)) {
            shots.add(nextShot);
            allFiredShots.add(nextShot);
          }
          boards.getRemainingOpCoord().remove(randIndex);
        }
      } while (shots.size() != shotsAvailable);
    }

    for (Coord currCoord : shots) {
      this.boards.updateOpponentBoard(currCoord, false);
    }




    return shots;
  }

  /**
   * Given the list of shots the opponent has fired on this player's board, report which
   * shots hit a ship on this player's board.
   *
   * @param opponentShotsOnBoard the opponent's shots on this player's board
   * @return a filtered list of the given shots that contain all locations of shots that hit a
   * ship on this board
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

    for (Coord currCoord : shotsThatHitOpponentShips) {
      modifyMasterShots(currCoord);
    }
  }

  /**
   * @param hitCoord the successful coordinates
   */
  private void modifyMasterShots(Coord hitCoord) {
    if (isInitialHit(hitCoord)) {
      initialHitPriority(hitCoord);
    } else {
      notInitialHitPriority(hitCoord);
    }
  }

  private boolean isInitialHit(Coord hitCoord) {
    List<Coord> surroundingCoords = new ArrayList<>();
    surroundingCoords.add(new Coord(hitCoord.getXpos() + 1, hitCoord.getYpos()));
    surroundingCoords.add(new Coord(hitCoord.getXpos() - 1, hitCoord.getYpos()));
    surroundingCoords.add(new Coord(hitCoord.getXpos(), hitCoord.getYpos() + 1));
    surroundingCoords.add(new Coord(hitCoord.getXpos(), hitCoord.getYpos() - 1));

    surroundingCoords.removeIf(this::isOut);

    for (Coord coord : surroundingCoords) {
      Coord actual = this.boards.getOpBoard()[coord.getYpos()][coord.getXpos()];
      if (actual.getStatus().equals(CoordStatus.HIT)) {
        return false;
      }
    }

    return true;
  }

  private void initialHitPriority(Coord hitCoord) {
    List<Coord> potentialPriority = new ArrayList<>();
    potentialPriority.add(new Coord(hitCoord.getXpos() + 1, hitCoord.getYpos()));
    potentialPriority.add(new Coord(hitCoord.getXpos() - 1, hitCoord.getYpos()));
    potentialPriority.add(new Coord(hitCoord.getXpos(), hitCoord.getYpos() + 1));
    potentialPriority.add(new Coord(hitCoord.getXpos(), hitCoord.getYpos() - 1));

    for (Coord potential : potentialPriority) {
      if (potential.getXpos() > -1 && potential.getXpos() < width
          && potential.getYpos() > -1 && potential.getYpos() < height
          && !this.allFiredShots.contains(potential)) {
        this.masterShots.remove(potential);
        this.masterShots.add(0, potential);
      }
    }
  }


  private void notInitialHitPriority(Coord hitCoord) {
    List<Coord> surroundingCoords = new ArrayList<>();

    surroundingCoords.add(new Coord(hitCoord.getXpos() + 1, hitCoord.getYpos()));
    surroundingCoords.add(new Coord(hitCoord.getXpos() - 1, hitCoord.getYpos()));
    surroundingCoords.add(new Coord(hitCoord.getXpos(), hitCoord.getYpos() + 1));
    surroundingCoords.add(new Coord(hitCoord.getXpos(), hitCoord.getYpos() - 1));

    surroundingCoords.removeIf(this::isOut);

    surroundingCoords.removeIf(
        potential -> (!this.boards.getOpBoard()[potential.getYpos()][potential.getXpos()]
            .getStatus().equals(CoordStatus.HIT)));


    List<Coord> oppositeCoords = new ArrayList<>();
    for (Coord coord : surroundingCoords) {
      if (coord.getXpos() < hitCoord.getXpos()) {
        oppositeCoords.add(new Coord(coord.getXpos() + 2, coord.getYpos()));
      } else if (coord.getXpos() > hitCoord.getXpos()) {
        oppositeCoords.add(new Coord(coord.getXpos() - 2, coord.getYpos()));
      } else if (coord.getYpos() < hitCoord.getYpos()) {
        oppositeCoords.add(new Coord(coord.getXpos(), coord.getYpos() + 2));
      } else if (coord.getYpos() > hitCoord.getYpos()) {
        oppositeCoords.add(new Coord(coord.getXpos(), coord.getYpos() - 2));
      }
    }

    oppositeCoords.removeIf(this::isOut);


    for (Coord coord : oppositeCoords) {
      if (!this.allFiredShots.contains(coord)) {
        this.masterShots.remove(coord);
        this.masterShots.add(0, coord);
      }
    }

  }


  private boolean isOut(Coord coord) {
    return coord.getXpos() < 0 || coord.getXpos() > width - 1
        || coord.getYpos() < 0 || coord.getYpos() > height - 1;
  }

  /**
   * Set up the master shot list that the AiPlayer should shoot from
   */
  private void createMasterShotList(int height, int width) {

    //first and every two rows
    for (int i = 0; i < this.height; i += 3) {
      for (int j = 0; j < this.width; j += 3) {
        masterShots.add(this.boards.getOpBoard()[i][j]);
      }
    }

    //second and every two rows
    for (int i = 1; i < this.height; i += 3) {
      for (int j = 1; j < this.width; j += 3) {
        masterShots.add(this.boards.getOpBoard()[i][j]);
      }
    }

    //third and every two rows
    for (int i = 2; i < this.height; i += 3) {
      for (int j = 2; j < this.width; j += 3) {
        masterShots.add(this.boards.getOpBoard()[i][j]);
      }
    }

    //calculate their distance
    for (Coord masterShot : this.masterShots) {
      masterShot.calculateDistanceToCenter(height, width);
    }

    //sort the list by their distance
    Collections.sort(this.masterShots);
  }
}
