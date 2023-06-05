package cs3500.pa03;

import cs3500.pa03.controller.BattleSalvoController;
import cs3500.pa03.controller.Controller;
import cs3500.pa03.model.AbstractPlayer;
import cs3500.pa03.model.AiPlayer;
import cs3500.pa03.model.ManualPlayer;
import cs3500.pa03.view.SingleManualPlayerView;
import cs3500.pa03.view.View;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

/**
 * This is the main driver of this project.
 */
public class Driver {
  /**
   * Project entry point
   *
   * @param args - no command line args required
   */
  public static void main(String[] args) {
    Random randomP1 = new Random();
    Random randomP2 = new Random();
    Readable terminalInput = new InputStreamReader(System.in);
    Appendable terminalOutput = new PrintStream(System.out);
    Scanner scan = new Scanner(terminalInput);

    View singlePlayerView = new SingleManualPlayerView(scan, terminalOutput);
    AbstractPlayer playerOne = new AiPlayer(randomP1);
    AbstractPlayer playerTwo = new ManualPlayer(randomP2, singlePlayerView);

    Controller singlePlayerController = new BattleSalvoController(playerOne,
        playerTwo, singlePlayerView, scan);
    singlePlayerController.run();
  }
}