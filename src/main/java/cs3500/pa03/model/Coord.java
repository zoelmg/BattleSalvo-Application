package cs3500.pa03.model;

/**
 * Represent a Coordinate on the board of BattleSalvo
 */
public class Coord implements Comparable<Coord> {
  private int xpos;
  private int ypos;
  private CoordStatus status;
  private int distanceToCenter;

  /**
   * Initialize a coordinate on the board
   *
   * @param xpos the horizontal index of the coordinate on the board
   * @param ypos the vertical index of the coordinate on the board
   */
  public Coord(int xpos, int ypos) {
    this.xpos = xpos;
    this.ypos = ypos;
    this.status = CoordStatus.EMPTY;
    this.distanceToCenter = 0;
  }

  /**
   * Initialize a coordinate on the board with its given status
   *
   * @param xpos the horizontal index of the coordinate on the board
   * @param ypos the vertical index of the coordinate on the board
   * @param status the status of the coordinate
   */
  public Coord(int xpos, int ypos, CoordStatus status) {
    this.xpos = xpos;
    this.ypos = ypos;
    this.status = status;
    this.distanceToCenter = 0;
  }



  /**
   * Get the x-position of this coordinate
   *
   * @return x-position
   */
  public int getXpos() {
    return this.xpos;
  }

  /**
   * Get the y-position of this coordinate
   *
   * @return y-position
   */
  public int getYpos() {
    return this.ypos;
  }

  /**
   * Get the status of this coordinate
   *
   * @return the status of the coordinate
   */
  public CoordStatus getStatus() {
    return this.status;
  }

  /**
   * Set the status of this coordinate
   *
   * @param status the status of this coordinate
   */
  public void setStatus(CoordStatus status) {
    this.status = status;
  }

  /**
   * Represent the status of this coordinate as a String
   *
   * @return string representation of this coordinate's status using the initial
   */
  public String coordStatusAsString() {
    return switch (this.status) {
      case BATTLESHIP -> " B ";
      case DESTROYER -> " D ";
      case SUBMARINE -> " S ";
      case CARRIER -> " C ";
      case HIT -> " H ";
      case MISS -> " M ";
      case EMPTY -> " O ";
    };
  }

  /**
   * Determine if the given object is the same as this coordinate
   *
   * @param obj a given object
   * @return if the given object is the same as this coordinate
   */
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Coord) {
      Coord coord = (Coord) obj;
      return this.xpos == coord.xpos && this.ypos == coord.ypos;
    }

    return false;
  }

  /**
   *
   * @param o the coordinate that this coordinate is being compared to
   * @return the integer representing which coordinate comes first
   */
  @Override
  public int compareTo(Coord other) {
    // Compare the distances to determine the ordering
    return Integer.compare(distanceToCenter, other.getDistanceToCenter());
  }

  public void calculateDistanceToCenter(int boardHeight, int boardWidth) {
    int centerX = boardWidth / 2;
    int centerY = boardHeight / 2;

    int dx = Math.abs(xpos - centerX);
    int dy = Math.abs(ypos - centerY);

    this.distanceToCenter = (int) Math.sqrt(dx * dx + dy * dy);
  }


  public int getDistanceToCenter() {
    return this.distanceToCenter;
  }



}
