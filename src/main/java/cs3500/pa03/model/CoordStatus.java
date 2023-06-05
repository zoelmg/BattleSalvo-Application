package cs3500.pa03.model;

/**
 * Represent the coordinate status of this coordinate
 */
public enum CoordStatus {
  /**
   * The coordinate where a ship is located has been hit
   */
  HIT,
  /**
   * The coordinate has been hit but there are no ship here
   */
  MISS,
  /**
   * There are no ships here on the user's board
   * or there are not enough information on the opponent's board
   */
  EMPTY,
  /**
   * There is Carrier here
   */
  CARRIER,
  /**
   * There is Battleship here
   */
  BATTLESHIP,
  /**
   * There is Destroyer here
   */
  DESTROYER,
  /**
   * There is Submarine here
   */
  SUBMARINE;

}
