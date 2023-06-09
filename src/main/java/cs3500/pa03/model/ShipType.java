package cs3500.pa03.model;

/**
 * Represent the different ShipTypes
 */
public enum ShipType {
  /**
   * Carrier takes 6 coordinates on BattleSalvo board
   */
  CARRIER(6),
  /**
   * Battleship takes 5 coordinates on BattleSalvo board
   */
  BATTLESHIP(5),
  /**
   * Destroyer takes 4 coordinates on BattleSalvo board
   */
  DESTROYER(4),
  /**
   * Submarine takes 3 coordinates on BattleSalvo board
   */
  SUBMARINE(3);

  /**
   * The amount of coordinates that this ship type
   * takes on the BattleSalvo board
   */
  private final int size;

  /**
   * Set the size of the ship
   *
   * @param size how many coordinates this ships takes up on the board
   */
  ShipType(int size) {
    this.size = size;
  }

  /**
   * Get the size of this ShipType
   *
   * @return the size of the ShipType
   */
  public int getSize() {
    return size;
  }

  /**
   * Determine the type of ship that should be
   * at a coordinate
   *
   * @return the type of Ship at coordinate
   */
  public CoordStatus getShipStatusAtCoord() {
    return switch (this) {
      case BATTLESHIP -> CoordStatus.BATTLESHIP;
      case DESTROYER -> CoordStatus.DESTROYER;
      case SUBMARINE -> CoordStatus.SUBMARINE;
      case CARRIER -> CoordStatus.CARRIER;
    };
  }
}
