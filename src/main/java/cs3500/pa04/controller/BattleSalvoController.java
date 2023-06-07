package cs3500.pa04.controller;

import cs3500.pa04.model.Coord;
import cs3500.pa04.model.Player;
import cs3500.pa04.model.Ship;
import cs3500.pa04.model.ShipType;
import cs3500.pa04.model.ValidEntries;
import cs3500.pa04.view.View;
import java.util.InputMismatchException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


/**
 * Represent the controller BattleSalvo Game of Two Players
 */
public class BattleSalvoController implements Controller {
  private final Player playerOne;
  private final Player playerTwo;
  private final View gameDisplay;
  private final Scanner scan;

  /**
   * Initialize a game for one Ai player and one Manual Player
   *
   * @param p1          Player One of the game
   * @param p2          Player two of the game
   * @param gameDisplay the display of the game
   * @param scan        scanning for the user input
   */
  public BattleSalvoController(Player p1, Player p2, View gameDisplay, Scanner scan) {
    this.playerOne = p1;
    this.playerTwo = p2;
    this.gameDisplay = gameDisplay;
    this.scan = scan;
  }

  /**
   * Runs the game between Two Player
   */
  @Override
  public void run() {
    int[] dimensions = askForBoardDimension();
    int maxFleetSize = Math.min(dimensions[0], dimensions[1]);
    Map<ShipType, Integer> desiredFleet = askForFleet(maxFleetSize);
    List<Ship> p1Ship = playerOne.setup(dimensions[0], dimensions[1], desiredFleet);
    List<Ship> p2Ship = playerTwo.setup(dimensions[0], dimensions[1], desiredFleet);
    gameInSession(p1Ship, p2Ship);
    endGame(p1Ship, p2Ship);
  }


  /**
   * ask the user for dimension until valid dimension is inputted
   *
   * @return an array containing the height and width of the board
   */
  private int[] askForBoardDimension() {
    gameDisplay.welcomeMessage();

    int[] dimensions = new int[2];
    int height = -1;
    int width = -1;

    while (true) {
      try {
        height = scan.nextInt();
        width = scan.nextInt();
        if (ValidEntries.validBoardDimension(height, width)) {
          dimensions[0] = height;
          dimensions[1] = width;
          break;
        } else {
          gameDisplay.invalidBoardSizeMessage();
        }
      } catch (InputMismatchException err) {
        scan.nextLine();
        gameDisplay.invalidBoardSizeMessage();
      }
    }
    return dimensions;
  }

  /**
   * ask the user for desired fleet until valid fleet is inputted
   *
   * @param maxFleetSize the maximum allowed fleet size
   * @return desired amount of size for each ship type in the fleet
   */
  private Map<ShipType, Integer> askForFleet(int maxFleetSize) {
    gameDisplay.desiredFleetMessage(maxFleetSize);

    Map<ShipType, Integer> fleet = new LinkedHashMap<>();

    while (true) {
      try {
        fleet.put(ShipType.CARRIER, scan.nextInt());
        fleet.put(ShipType.BATTLESHIP, scan.nextInt());
        fleet.put(ShipType.DESTROYER, scan.nextInt());
        fleet.put(ShipType.SUBMARINE, scan.nextInt());

        if (ValidEntries.validFleet(fleet, maxFleetSize)) {
          break;
        } else {
          gameDisplay.invalidDesiredFleetMessage(maxFleetSize);
        }
      } catch (InputMismatchException err) {
        scan.nextLine();
        gameDisplay.invalidDesiredFleetMessage(maxFleetSize);
      }
    }
    return fleet;
  }

  /**
   * Each Player takes turn in the game until the game ends
   */
  private void gameInSession(List<Ship> playerOneShips, List<Ship> playerTwoShips) {

    while (!(playerOneShips.size() == (0) || playerTwoShips.size() == (0))) {
      List<Coord> playerTwoShots = playerTwo.takeShots();
      List<Coord> playerOneShots = playerOne.takeShots();

      List<Coord> playerOneDamage = playerOne.reportDamage(playerTwoShots);
      List<Coord> playerTwoDamage = playerTwo.reportDamage(playerOneShots);

      playerTwo.successfulHits(playerOneDamage);
      playerOne.successfulHits(playerTwoDamage);
    }
  }

  /**
   * shows the ending scene of the game
   *
   * @param p1Ship The list of remaining ships belong to the p1
   * @param p2Ship The list of remaining ships belonging to the p2Ship
   */
  private void endGame(List<Ship> p1Ship, List<Ship> p2Ship) {
    if (p1Ship.size() > p2Ship.size()) {
      gameDisplay.printAnyStringMessage("You Lost :(");
    } else if (p1Ship.size() < p2Ship.size()) {
      gameDisplay.printAnyStringMessage("You Won! :)");
    } else {
      gameDisplay.printAnyStringMessage("Tied");
    }
    scan.close();
  }
}
