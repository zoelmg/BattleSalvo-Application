package cs3500.pa03.model;

import java.util.Map;

/**
 * A Utility class containing methods checking
 * the validity of inputs for BattleSalvo
 */
public class ValidEntries {
  /**
   * Checks if the desired board dimension is valid
   *
   * @param height the height of the board
   * @param width  the width of the board
   * @return if the two dimensions are valid
   */
  public static boolean validBoardDimension(int height, int width) {
    return (height >= 6 && height <= 15 && width >= 6 && width <= 15);
  }

  /**
   * Checks if the desired fleet is valid
   *
   * @param fleet        the fleet with desired amount of each ShipType
   * @param maxFleetSize the maximum amount of ship allowed in the fleet
   * @return if the fleet is valid
   */
  public static boolean validFleet(Map<ShipType, Integer> fleet, int maxFleetSize) {
    int totalFleet = 0;

    for (Map.Entry<ShipType, Integer> value : fleet.entrySet()) {
      totalFleet = totalFleet + value.getValue();
    }

    return (fleet.size() == 4 && totalFleet <= maxFleetSize && totalFleet > 0);
  }


  /**
   * Determine if a list of shots are all valid, the criteria being:
   * 1. The shot must be in the list of remaining opponent coordinates
   * 2. the X and Y coordinates of the desired shot cannot be out of bound on the board
   *
   * @param shot   ths shot a user would like to make
   * @param boards the board of the user
   * @return if the shot is a valid shot
   */
  public static boolean validPlayerShot(Coord shot, TwoBoards boards) {
    return !(shot.getXpos() > boards.getOpBoard()[0].length || shot.getXpos() < 0
      || shot.getYpos() > boards.getOpBoard().length || shot.getYpos() < 0
      || !(boards.getRemainingOpCoord().contains(shot)));

  }
}
