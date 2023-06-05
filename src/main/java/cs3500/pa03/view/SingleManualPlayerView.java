package cs3500.pa03.view;

import cs3500.pa03.model.Coord;
import cs3500.pa03.model.TwoBoards;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Represent the view from a SingleManualPlayer
 */
public class SingleManualPlayerView implements View {
  private Appendable out;
  private Scanner scan;


  /**
   * Initialize the SingleManualPlayerView
   *
   * @param scan scanner for when asking the single manual player for input
   * @param out  out printing messages to show user
   */
  public SingleManualPlayerView(Scanner scan, Appendable out) {
    this.out = out;
    this.scan = scan;
  }

  /**
   * Welcome and beginning message shown to the manual player
   */
  @Override
  public void welcomeMessage() {
    try {
      out.append("Hello! Welcome to the OOD BattleSalvo Game!\n"
          + "Please enter a valid height and width below\n"
          + "---------------------------------------\n");
    } catch (IOException err) {
      throw new RuntimeException("Could not append Message");
    }
  }

  /**
   * invalid board size entered message shown to the manual player
   */
  @Override
  public void invalidBoardSizeMessage() {
    try {
      out.append("---------------------------------------\n"
          + "Uh Oh! You've entered invalid dimensions. \n"
          + "Please remember that the height and width of the game\n"
          + "must be in the range (6, 15), inclusive.\n"
          + "Try again!\n"
          + "---------------------------------------\n");
    } catch (IOException err) {
      throw new RuntimeException("Could not append Message");
    }
  }

  /**
   * message shown to the manual player when prompting for a desired fleet size and types
   *
   * @param maxFleetSize the maximum amount of ships that the user should input
   */
  @Override
  public void desiredFleetMessage(int maxFleetSize) {
    try {
      out.append("Please enter your fleet in the order "
          + "[Carrier, Battleship, Destroyer, Submarine].\n"
          + "Remember, your fleet may not exceed size " + maxFleetSize + "\n"
          + "---------------------------------------\n");
    } catch (IOException err) {
      throw new RuntimeException("Could not append Message");
    }
  }

  /**
   * message shown to the manual player when invalid fleet size and type was entered
   *
   * @param maxFleetSize the maximum amount of ships that the user should input
   */
  @Override
  public void invalidDesiredFleetMessage(int maxFleetSize) {
    try {
      out.append("---------------------------------------\n"
          + "Uh Oh! You've entered invalid fleet sizes.\n"
          + "Please enter your fleet in the order "
          + "[Carrier, Battleship, Destroyer, Submarine].\n"
          + "Try again!\n"
          + "Remember, your fleet may not exceed size " + maxFleetSize + "\n");
    } catch (IOException err) {
      throw new RuntimeException("Could not append Message");
    }
  }

  /**
   * display the manual player's board and its opponent's board in the manual player's point of view
   *
   * @param boards         the two boards from the manual player's point of view
   * @return the list of coordinate of shots that the manual player would like to make
   */
  @Override
  public List<Coord> showBoard(TwoBoards boards) {
    List<Coord> userWant = new ArrayList<>();
    try {
      out.append("---------------------------------------\n"
          + "Direction: Top Left is (0,0), move right for (1, 0) and move down for (0, 1)\n"
          + "Opponent's Board: \n"
          + boardAsString(boards.getOpBoard())
          + "Your Board: \n"
          + boardAsString(boards.getMyBoard())
          + "Please enter " + boards.howManyShotsAvailable() + " valid shots\n"
          + "---------------------------------------\n");

      try {
        for (int i = 0; i < boards.howManyShotsAvailable(); i++) {
          userWant.add(new Coord(scan.nextInt(), scan.nextInt()));
        }
      } catch (InputMismatchException err) {
        scan.next();
        return showBoard(boards);
      }

    } catch (IOException err) {
      throw new RuntimeException("Could not append Message");
    }
    return userWant;
  }

  /**
   * display a given board to be displayed in a string representation
   *
   * @param board the board to be displayed
   * @return a string representation of the board
   */
  private String boardAsString(Coord[][] board) {
    StringBuilder boardAsString = new StringBuilder();
    for (Coord[] coords : board) {
      for (Coord coord : coords) {
        boardAsString.append(coord.coordStatusAsString()).append(" ");
      }
      boardAsString.append("\n");
    }
    return boardAsString.toString();
  }


  /**
   * display any given message
   *
   * @param message a given message
   */
  @Override
  public void printAnyStringMessage(String message) {
    try {
      out.append(message);
    } catch (IOException err) {
      throw new RuntimeException("Could not append message");
    }
  }
}
