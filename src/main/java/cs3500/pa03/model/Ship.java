package cs3500.pa03.model;

import java.util.List;

/**
 * Represent a Ship in BattleSalvo
 */
public class Ship {
  private List<Coord> location;
  private ShipType ship;

  /**
   * Initialize a ship with its location and shiptype
   *
   * @param location the coordinates of the ship on the game board
   * @param ship     the type of ship
   */
  public Ship(List<Coord> location, ShipType ship) {
    this.location = location;
    this.ship = ship;
  }

  /**
   * get the location of this ship
   *
   * @return the location of this shipt
   */
  public List<Coord> getLocation() {
    return this.location;
  }
}
