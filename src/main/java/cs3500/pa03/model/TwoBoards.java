package cs3500.pa03.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Represents the player's and their opponent's board from a
 * player's point of view in the game of BattleSalvo
 */
public class TwoBoards {
  private Coord[][] myBoard;
  private Coord[][] opBoard;
  private List<Ship> myShips;
  private List<Coord> allOccupiedCoord;
  private List<Coord> remainingOpCoord;
  private Random random;

  /**
   * Initialize the boards by setting up the board
   * with randomized fleets by calling on private methods
   *
   * @param height       The height of the board
   * @param width        The width of the board
   * @param desiredFleet The fleet specification
   * @param random       A random used to generate location of the fleet
   */
  public TwoBoards(int height, int width, Map<ShipType, Integer> desiredFleet, Random random) {
    this.myBoard = new Coord[height][width];
    this.opBoard = new Coord[height][width];
    this.random = random;
    this.remainingOpCoord = new ArrayList<>();
    this.myShips = new ArrayList<>();
    this.allOccupiedCoord = new ArrayList<>();
    generateFleet(height, width, desiredFleet);
    setupBoard(opBoard);
    for (Coord[] coords : opBoard) {
      remainingOpCoord.addAll(Arrays.asList(coords));
    }
    setupMyBoardWithFleet();
  }

  private void generateFleet(int height, int width, Map<ShipType, Integer> specifications) {

    List<Coord> takenPlaces = new ArrayList<>();
    List<Ship> placedShips = new ArrayList<>();

    List<List<Coord>> carrierPlaces = this.getAllPlacements(height, width, ShipType.CARRIER);
    List<List<Coord>> battleshipPlaces = this.getAllPlacements(height, width, ShipType.BATTLESHIP);
    List<List<Coord>> destroyerPlaces = this.getAllPlacements(height, width, ShipType.DESTROYER);
    List<List<Coord>> submarinePlaces = this.getAllPlacements(height, width, ShipType.SUBMARINE);

    Random rand = new Random();
    placedShips.addAll(this.getShips(ShipType.CARRIER, carrierPlaces, takenPlaces,
        specifications.get(ShipType.CARRIER), rand.nextInt()));
    placedShips.addAll(this.getShips(ShipType.BATTLESHIP, battleshipPlaces, takenPlaces,
        specifications.get(ShipType.BATTLESHIP), rand.nextInt()));
    placedShips.addAll(this.getShips(ShipType.DESTROYER, destroyerPlaces, takenPlaces,
        specifications.get(ShipType.DESTROYER), rand.nextInt()));
    placedShips.addAll(this.getShips(ShipType.SUBMARINE, submarinePlaces, takenPlaces,
        specifications.get(ShipType.SUBMARINE), rand.nextInt()));


    this.myShips = placedShips;
  }

  /**
   * @param type is type of the Ships that need to be placed & returned
   * @param carrierPlaces is all possible placements for given shiptype
   * @param takenPlaces is coords that are already occupied
   * @param numShips is desired num of ships to be placed on board and returned
   * @return a list of ships objects that are placed on board
   */
  private List<Ship> getShips(ShipType type, List<List<Coord>> carrierPlaces,
                              List<Coord> takenPlaces, int numShips, int randSeed) {
    List<Ship> placedShips = new ArrayList<>();

    Random random = new Random(randSeed);
    //place carriers
    for (int i = 0; i < numShips; i+=1) {
      //get one random placement
      int randNum = random.nextInt(0, carrierPlaces.size());
      List<Coord> newPlace = carrierPlaces.get(randNum);
      //if valid, add to list of ships, else set back i by one
      if (this.noOverlap(newPlace, takenPlaces)) {
        takenPlaces.addAll(newPlace);
        placedShips.add(new Ship(newPlace, type));
        carrierPlaces.remove(randNum);
      } else {
        i-=1;
      }
    }
    return placedShips;
  }

  /**
   * @param newPlace is new set of coords where ship can be placed
   * @param takenPlaces is list of coords already occupied
   * @return true if new set of coords is not in takenPlaces list
   */
  private boolean noOverlap(List<Coord> newPlace, List<Coord> takenPlaces) {
    for (Coord c : newPlace) {
      if (takenPlaces.contains(c)) { return false; }
    }
    return true;
  }

  /**
   * @param boardHeight is height of board given by user
   * @param boardWidth is width of board given by user
   * @param type is type of ship
   * @return a list of possible placements on board based on ship's length
   */
  private List<List<Coord>> getAllPlacements(int boardHeight, int boardWidth, ShipType type) {
    int shipSize = type.getSize();
    List<List<Coord>> allPlacements = new ArrayList<>();

    //generate horizontal placements
    allPlacements.addAll(this.allPlacementsHelper(boardHeight, boardWidth, type));

    //generate vertical placements
    allPlacements.addAll(this.allPlacementsHelper(boardWidth, boardHeight, type));

    return allPlacements;
  }

  /**
   * @param sizeOne is first dimension's size of board
   * @param sizeTwo is second dimensions size of board
   * @param type is type of ship placement being calculated
   * @return a list of all locations this ship type can be placed on
   */
  private List<List<Coord>> allPlacementsHelper(int sizeOne, int sizeTwo, ShipType type) {
    int shipSize = type.getSize();
    List<List<Coord>> allPlacements = new ArrayList<>();
    //generate all placements placements
    for (int y = 0; y < sizeOne; y +=1) {
      //placements in one direction
      for (int h = 0; h + shipSize <= sizeTwo; h+=1) {
        List<Coord> thisPlace = new ArrayList<>();
        //single placement
        for (int x = h; x < h + shipSize; x+=1) {
          thisPlace.add(new Coord(x, y, type.getStatus()));
        }
        allPlacements.add(thisPlace);
      }
    }
    return allPlacements;
  }







  /**
   * setup myBoard with where this user's fleets are located
   */
  private void setupMyBoardWithFleet() {
    setupBoard(myBoard);
    for (Ship currentShip : myShips) {
      for (Coord coord : currentShip.getLocation()) {
        myBoard[coord.getYpos()][coord.getXpos()] = coord;
      }
    }

  }

  /**
   * initialize board with information in the beginning(none, so all coordinates are empty);
   */
  private void setupBoard(Coord[][] board) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        board[i][j] = new Coord(i, j);
      }
    }
  }


  /**
   * update the status of coordinate on my board based on the opponent's hit
   *
   * @param opponentHit the coordinate on my board that the opponent took shot to
   * @return true if the opponent has hit a coordinate where a ship resides
   */
  public boolean updateMyBoard(Coord opponentHit) {
    for (Coord myCoord : allOccupiedCoord) {
      if (opponentHit.getXpos() == myCoord.getXpos()
          && opponentHit.getYpos() == myCoord.getYpos()) {
        myBoard[opponentHit.getYpos()][opponentHit.getXpos()].setStatus(CoordStatus.HIT);
        return true;
      }
    }
    myBoard[opponentHit.getYpos()][opponentHit.getXpos()].setStatus(CoordStatus.MISS);
    return false;
  }


  /**
   * update the status of coordinates on my opponent's board from my
   * point of view based on my shot and hits
   *
   * @param coord the coordinate on my opponent's board that the user would like to update status
   * @param successFulHit whether the given coordinate was a successful or miss shot
   */
  public void updateOpponentBoard(Coord coord, boolean successFulHit) {
    if (successFulHit) {
      opBoard[coord.getYpos()][coord.getXpos()].setStatus(CoordStatus.HIT);
      remainingOpCoord.remove(coord);
    } else {
      opBoard[coord.getYpos()][coord.getXpos()].setStatus(CoordStatus.MISS);
      remainingOpCoord.remove(coord);
    }
  }


  /**
   * Update my fleet as coordinates of myBoard are being updated,
   * if all coordinates of a ship has coordinate status of HIT,
   * the ship was sunk and will be removed from myShips
   */
  public void updateRemainingShips() {
    Iterator<Ship> fleetIterator = myShips.iterator();

    while (fleetIterator.hasNext()) {
      Ship ship = fleetIterator.next();
      boolean allCoordsHit = true;

      for (Coord coord : ship.getLocation()) {
        if (!coord.getStatus().equals(CoordStatus.HIT)) {
          allCoordsHit = false;
          break;
        }
      }

      if (allCoordsHit) {
        fleetIterator.remove();
      }
    }
  }

  /**
   * Determines the number of shots the player that this TwoBoards belongs to
   * based on how many existing fleets are left and how many EMPTY coordinates
   * the opponent's board have left from the player's point of view
   *
   * @return the number of shots available
   */
  public int howManyShotsAvailable() {
    return Math.min(myShips.size(), remainingOpCoord.size());
  }

  /**
   * get the user's board
   *
   * @return the user's board
   */
  public Coord[][] getMyBoard() {
    return myBoard;
  }

  /**
   * get the opponent's board
   *
   * @return the opponent's board from user's point of view
   */
  public Coord[][] getOpBoard() {
    return opBoard;
  }

  /**
   * get the user's list of ships that are still on the user's board
   *
   * @return the user's list of ships
   */
  public List<Ship> getFleet() {
    return myShips;
  }

  /**
   * get the remaining list of coordinates on the opponent's board
   *
   * @return the remaining coordinates on the opponent's board
   */
  public List<Coord> getRemainingOpCoord() {
    return remainingOpCoord;
  }
}
