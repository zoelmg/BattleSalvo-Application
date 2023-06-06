package cs3500.pa04.view;

import cs3500.pa04.model.Coord;
import cs3500.pa04.model.TwoBoards;
import java.util.List;

/**
 * Represent Displays of this BattleSalvo game
 */
public interface View {
  /**
   * Welcome and beginning message
   */
  void welcomeMessage();

  /**
   * invalid board size entered message
   */
  void invalidBoardSizeMessage();

  /**
   * message prompting for a desired fleet size and types
   *
   * @param maxFleetSize the maximum amount of ships that the user should input
   */
  void desiredFleetMessage(int maxFleetSize);

  /**
   * message shown when invalid fleet size and type was entered
   *
   * @param maxFleetSize the maximum amount of ships that the user should input
   */
  void invalidDesiredFleetMessage(int maxFleetSize);

  /**
   * display boards of the Player
   *
   * @param boards the two boards from player's point of view
   * @return the list of coordinate of shots that the manual player would like to make
   */
  List<Coord> showBoard(TwoBoards boards);

  /**
   * display any given message
   *
   * @param message a given message
   */
  void printAnyStringMessage(String message);
}
