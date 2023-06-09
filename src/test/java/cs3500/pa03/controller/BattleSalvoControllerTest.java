package cs3500.pa03.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa03.model.AiPlayer;
import cs3500.pa03.model.ManualPlayer;
import cs3500.pa03.model.Player;
import cs3500.pa03.view.SingleManualPlayerView;
import cs3500.pa03.view.View;
import java.io.StringReader;
import java.util.Random;
import java.util.Scanner;
import org.junit.jupiter.api.Test;


/**
 * Test for methods of BattleSalvoController
 * NOTES: @BeforeEach was not used to abstract set up
 * because Player instantiation depends on scanner that reads
 * different Readable in the format of an immutable string
 */
class BattleSalvoControllerTest {

  /**
   * The manual player ties with the AI player
   */
  @Test
  void testUserTied() {
    Random randomP1 = new Random(24);
    Random randomP2 = new Random(24);
    Appendable output = new StringBuilder();
    String userInput = "5 5 "
        + "6 6 "
        + "0 0 2 0 "
        + "1 1 1 1";
    Scanner scan = new Scanner(userInput);
    View singlePlayerView = new SingleManualPlayerView(scan, output);
    Player playerOne = new AiPlayer(randomP1);
    Player playerTwo = new AiPlayer(randomP2);

    Controller singlePlayerController = new BattleSalvoController(playerOne,
        playerTwo, singlePlayerView, scan);

    singlePlayerController.run();


    assertEquals(ExpectedGameOutput.userTie, output.toString());
  }

  /**
   * The manual player loses the game against the AI player
   */
  @Test
  void testUserWin() {
    Random randomP1 = new Random(30);
    Random randomP2 = new Random(35);

    String userInput = """
        6 6 
        1 1 1 1 
        0 2 0 5 1 2 1 4 
        1 5 2 2 2 4 2 5
        3 1 3 2 3 4 3 5
        4 1 4 2 4 4 4 5 
        5 1 5 2 5 3 5 4 
        5 5 0 0 0 1 0 3 
        0 4 1 0 1 1 1 3
        2 0 2 1 2 3 3 0 
        3 3 4 0 4 3 5 0
        """;
    Readable input = new StringReader(userInput);

    Appendable output = new StringBuilder();
    Scanner scan = new Scanner(input);

    View singlePlayerView = new SingleManualPlayerView(scan, output);
    Player playerOne = new AiPlayer(randomP1);
    Player playerTwo = new ManualPlayer(randomP2, singlePlayerView);

    Controller singlePlayerController = new BattleSalvoController(playerOne,
        playerTwo, singlePlayerView, scan);

    singlePlayerController.run();

    assertEquals(ExpectedGameOutput.userWon, output.toString());
  }

  /**
   * The manual player loses the game against the AI player
   */
  @Test
  void testUserLose() {
    Random randomP1 = new Random(5);
    Random randomP2 = new Random(29);

    String userInput = """
        string 0
        6 6 
        string string 0 0
        1 1 1 1 
        0 2 0 5 1 2 1 4 
        1 5 2 2 2 4 2 5
        3 1 3 2 3 4 3 5
        4 1 4 2 4 4 4 5 
        5 1 5 2 5 3 5 4 
        5 5 0 0 0 1 0 3 
        0 4 1 0 1 1 1 3
        2 0 2 1 2 3 3 0 
        3 3 4 0 4 3 5 0
        """;
    Readable input = new StringReader(userInput);

    Appendable output = new StringBuilder();
    Scanner scan = new Scanner(input);

    View singlePlayerView = new SingleManualPlayerView(scan, output);
    Player playerOne = new AiPlayer(randomP1);
    Player playerTwo = new ManualPlayer(randomP2, singlePlayerView);

    Controller singlePlayerController = new BattleSalvoController(playerOne,
        playerTwo, singlePlayerView, scan);

    singlePlayerController.run();

    assertEquals(ExpectedGameOutput.userLost, output.toString());
  }


}