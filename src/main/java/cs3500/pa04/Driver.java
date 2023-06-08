package cs3500.pa04;

import cs3500.pa04.client.ProxyDealer;
import cs3500.pa04.controller.BattleSalvoController;
import cs3500.pa04.controller.Controller;
import cs3500.pa04.model.AbstractPlayer;
import cs3500.pa04.model.AiPlayer;
import cs3500.pa04.model.ManualPlayer;
import cs3500.pa04.view.SingleManualPlayerView;
import cs3500.pa04.view.View;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
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
    /*
    try {
      Socket socket = new Socket("0.0.0.0", 35001);
      PrintStream sendToServer = new PrintStream(socket.getOutputStream());

      sendToServer.println("Hi Server");
    } catch (IOException e) {
      System.out.println(":(");
    }
*/

    try {
      if (args.length == 0) {
        runAiAgainstManualPlayer();
        ;
      } else if (args.length == 2) {
        String host = args[0];
        int port = Integer.parseInt(args[1]);
        runClient(host, port);
      } else {
        throw new IllegalArgumentException("Enter 0 arguments to play against this CPU Player"
            + "or Enter Host and Port to add this CPU Player to existing server");
      }
    } catch (IOException e) {
      System.out.println(":(");
    }
  }

  private static void runAiAgainstManualPlayer() {
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

  private static void runClient(String host, int port) throws IOException {
    Socket server = new Socket(host, port);
    Random random = new Random();
    Controller controller = new ProxyDealer(server, new AiPlayer(random));
    controller.run();
  }
}