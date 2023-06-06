package cs3500.pa03.view;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import cs3500.pa04.view.SingleManualPlayerView;
import cs3500.pa04.view.View;
import java.io.StringReader;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * Tests for methods for SingleManualPlayerView
 */
class SingleManualPlayerViewTest {
  Appendable exampleOut;
  Readable exampleIn;
  Scanner exampleScan;
  View exampleView;
  Appendable exampleErrorAppendable;
  View exampleErrorView;
  String message;

  /**
   * Initialize the setup to test all methods in
   * SingleManualPlayerView
   */
  @BeforeEach
  void initSetup() {
    exampleOut = new StringBuilder();
    message = "2 0 "
        + "check error 0 0";
    exampleIn = new StringReader(message);
    exampleScan = new Scanner(exampleIn);
    exampleView = new SingleManualPlayerView(exampleScan, exampleOut);
    exampleErrorAppendable = new MockAppendable();
    exampleErrorView = new SingleManualPlayerView(exampleScan, exampleErrorAppendable);

  }

  /**
   * Test method welcomeMessage displays the correct welcome message
   * that welcomes the user and ask for dimension input when called
   */
  @Test
  void testWelcomeMessage() {
    exampleView.welcomeMessage();
    assertEquals("Hello! Welcome to the OOD BattleSalvo Game!\n"
        + "Please enter a valid height and width below\n"
        + "---------------------------------------\n", exampleOut.toString());
    assertThrows(RuntimeException.class, () -> exampleErrorView.welcomeMessage());
  }

  /**
   * Test invalid dimension input message are correctly displayed
   * when called
   */
  @Test
  void testInvalidBoardSize() {
    exampleView.invalidBoardSizeMessage();
    assertEquals("---------------------------------------\n"
        + "Uh Oh! You've entered invalid dimensions. \n"
        + "Please remember that the height and width of the game\nmust be "
        + "in the range (6, 15), inclusive.\n"
        + "Try again!\n"
        + "---------------------------------------\n", exampleOut.toString());

    assertThrows(RuntimeException.class, () -> exampleErrorView.invalidBoardSizeMessage());
  }

  /**
   * Test the message of asking user to input desired fleet are correctly displayed
   * when desiredFleetMessage is called
   */
  @Test
  void testDesiredFleetMessage() {
    exampleView.desiredFleetMessage(6);
    assertEquals("Please enter your fleet in the order "
        + "[Carrier, Battleship, Destroyer, Submarine].\n"
        + "Remember, your fleet may not exceed size 6\n"
        + "---------------------------------------\n", exampleOut.toString());

    exampleView.desiredFleetMessage(7);
    assertEquals("Please enter your fleet in the order "
        + "[Carrier, Battleship, Destroyer, Submarine].\n"
        + "Remember, your fleet may not exceed size 6\n"
        + "---------------------------------------\n"
        + "Please enter your fleet in the order [Carrier, Battleship, Destroyer, Submarine].\n"
        + "Remember, your fleet may not exceed size 7\n"
        + "---------------------------------------\n", exampleOut.toString());
    assertThrows(RuntimeException.class, () -> exampleErrorView.desiredFleetMessage(6));
  }

  /**
   * Test the message of asking user to input another set of fleet
   * specification are correctly being displayed when invalidDesiredFleetMessage are called
   */
  @Test
  void testInvalidDesiredFleetMessage() {
    exampleView.invalidDesiredFleetMessage(6);
    assertEquals("---------------------------------------\n"
        + "Uh Oh! You've entered invalid fleet sizes.\n"
        + "Please enter your fleet in the order [Carrier, Battleship, Destroyer, Submarine].\n"
        + "Try again!\n"
        + "Remember, your fleet may not exceed size 6\n", exampleOut.toString());

    assertThrows(RuntimeException.class, () -> exampleErrorView.invalidDesiredFleetMessage(6));
  }

  /**
   * Test that show board is displaying boards when it is called and given its
   * respective parameters
   */
  /*
  @Test
  void testValidShowBoard() {
    Map<ShipType, Integer> exampleDesiredFleets = new LinkedHashMap<>();
    exampleDesiredFleets.put(ShipType.CARRIER, 2);
    exampleDesiredFleets.put(ShipType.BATTLESHIP, 0);
    exampleDesiredFleets.put(ShipType.DESTROYER, 0);
    exampleDesiredFleets.put(ShipType.SUBMARINE, 0);
    Random seededRandom = new Random(10);

    TwoBoards exampleBoards = new TwoBoards(6, 6, exampleDesiredFleets, seededRandom);

    exampleView.showBoard(exampleBoards, 1);
    assertEquals("---------------------------------------\n"
        + "Direction: Top Left is (0,0), move right for (1, 0) and move down for (0, 1)\n"
        + "Opponent's Board: \n"
        + " O   O   O   O   O   O  \n"
        + " O   O   O   O   O   O  \n"
        + " O   O   O   O   O   O  \n"
        + " O   O   O   O   O   O  \n"
        + " O   O   O   O   O   O  \n"
        + " O   O   O   O   O   O  \n"
        + "Your Board: \n"
        + " O   O   P   O   P   O  \n"
        + " O   O   P   O   P   O  \n"
        + " O   O   P   O   P   O  \n"
        + " O   O   P   O   P   O  \n"
        + " O   O   P   O   P   O  \n"
        + " O   O   P   O   P   O  \n"
        + "Please enter 1 valid shots\n"
        + "---------------------------------------\n", exampleOut.toString());
  }
*/
  /**
   * Test that show board correctly handles invalid inputs
   */

  /*
  void testInvalidShowBoard() {
    Map<ShipType, Integer> exampleDesiredFleets = new LinkedHashMap<>();
    exampleDesiredFleets.put(ShipType.CARRIER, 2);
    exampleDesiredFleets.put(ShipType.BATTLESHIP, 0);
    exampleDesiredFleets.put(ShipType.DESTROYER, 0);
    exampleDesiredFleets.put(ShipType.SUBMARINE, 0);
    Random seededRandom = new Random(10);

    TwoBoards exampleBoards = new TwoBoards(6, 6, exampleDesiredFleets, seededRandom);


    exampleView.showBoard(exampleBoards, 1);
    //check that showBoard does not throw an error but continues the game
    //when an input not of integer value is taken in
    assertDoesNotThrow(() -> exampleView.showBoard(exampleBoards, 1));
    assertThrows(RuntimeException.class, () -> exampleErrorView.showBoard(exampleBoards, 2));
  }
*/

  /**
   * Test that a given message will be correctly displayed
   * after calling printAnyStringMessage
   */
  @Test
  void testPrintAnyStringMessage() {
    exampleView.printAnyStringMessage("food");
    assertEquals("food", exampleOut.toString());
    assertThrows(RuntimeException.class, () -> exampleErrorView.printAnyStringMessage("food"));
  }
}