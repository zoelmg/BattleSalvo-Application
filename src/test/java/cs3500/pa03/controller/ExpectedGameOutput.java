package cs3500.pa03.controller;

/**
 * Class that stores expected output
 * strings for BattleSalvoController
 */
public class ExpectedGameOutput {
  /**
   * Game for when user won against Ai Player
   */
  public static String userWon = """  
      Hello! Welcome to the OOD BattleSalvo Game!
      Please enter a valid height and width below
      ---------------------------------------
      Please enter your fleet in the order [Carrier, Battleship, Destroyer, Submarine].
      Remember, your fleet may not exceed size 6
      ---------------------------------------
      ---------------------------------------
      Direction: Top Left is (0,0), move right for (1, 0) and move down for (0, 1)
      Opponent's Board:\s
       O   O   O   O   O   O \s
       O   O   O   O   O   O \s
       O   O   O   O   O   O \s
       O   O   O   O   O   O \s
       O   O   O   O   O   O \s
       O   O   O   O   O   O \s
      Your Board:\s
       O   O   C   O   O   B \s
       O   O   C   O   O   B \s
       D   O   C   O   O   B \s
       D   O   C   S   O   B \s
       D   O   C   S   O   B \s
       D   O   C   S   O   O \s
      Please enter 4 valid shots
      ---------------------------------------
      ---------------------------------------
      Direction: Top Left is (0,0), move right for (1, 0) and move down for (0, 1)
      Opponent's Board:\s
       O   O   O   O   O   O \s
       O   O   O   O   O   O \s
       H   H   O   O   O   O \s
       O   O   O   O   O   O \s
       O   M   O   O   O   O \s
       H   O   O   O   O   O \s
      Your Board:\s
       O   O   H   O   O   H \s
       O   O   C   O   O   B \s
       D   O   C   O   O   B \s
       D   O   C   S   O   B \s
       D   O   C   S   O   B \s
       D   M   H   S   O   O \s
      Please enter 4 valid shots
      ---------------------------------------
      ---------------------------------------
      Direction: Top Left is (0,0), move right for (1, 0) and move down for (0, 1)
      Opponent's Board:\s
       O   O   O   O   O   O \s
       O   O   O   O   O   O \s
       H   H   H   O   O   O \s
       O   O   O   O   O   O \s
       O   M   M   O   O   O \s
       H   M   M   O   O   O \s
      Your Board:\s
       O   O   H   O   O   H \s
       O   O   C   O   O   B \s
       D   O   C   M   O   B \s
       D   O   C   S   O   B \s
       H   M   C   S   O   B \s
       H   M   H   S   O   O \s
      Please enter 4 valid shots
      ---------------------------------------
      ---------------------------------------
      Direction: Top Left is (0,0), move right for (1, 0) and move down for (0, 1)
      Opponent's Board:\s
       O   O   O   O   O   O \s
       O   O   O   H   O   O \s
       H   H   H   H   O   O \s
       O   O   O   O   O   O \s
       O   M   M   M   O   O \s
       H   M   M   M   O   O \s
      Your Board:\s
       O   O   H   O   O   H \s
       O   O   H   O   O   B \s
       D   O   C   M   O   B \s
       D   O   C   H   O   B \s
       H   M   H   S   O   B \s
       H   M   H   S   O   M \s
      Please enter 4 valid shots
      ---------------------------------------
      ---------------------------------------
      Direction: Top Left is (0,0), move right for (1, 0) and move down for (0, 1)
      Opponent's Board:\s
       O   O   O   O   O   O \s
       O   O   O   H   H   O \s
       H   H   H   H   H   O \s
       O   O   O   O   O   O \s
       O   M   M   M   M   O \s
       H   M   M   M   M   O \s
      Your Board:\s
       M   O   H   O   O   H \s
       M   M   H   O   O   B \s
       D   O   C   M   O   B \s
       D   O   C   H   O   B \s
       H   M   H   H   O   B \s
       H   M   H   S   O   M \s
      Please enter 4 valid shots
      ---------------------------------------
      ---------------------------------------
      Direction: Top Left is (0,0), move right for (1, 0) and move down for (0, 1)
      Opponent's Board:\s
       O   O   O   O   O   O \s
       O   O   O   H   H   M \s
       H   H   H   H   H   H \s
       O   O   O   O   O   H \s
       O   M   M   M   M   M \s
       H   M   M   M   M   O \s
      Your Board:\s
       M   O   H   O   M   H \s
       M   M   H   O   M   B \s
       D   O   C   M   O   B \s
       H   O   C   H   O   B \s
       H   M   H   H   M   B \s
       H   M   H   S   O   M \s
      Please enter 4 valid shots
      ---------------------------------------
      ---------------------------------------
      Direction: Top Left is (0,0), move right for (1, 0) and move down for (0, 1)
      Opponent's Board:\s
       M   O   O   O   O   O \s
       H   O   O   H   H   M \s
       H   H   H   H   H   H \s
       H   O   O   O   O   H \s
       O   M   M   M   M   M \s
       H   M   M   M   M   M \s
      Your Board:\s
       M   O   H   O   M   H \s
       M   M   H   M   M   B \s
       D   O   C   M   O   H \s
       H   O   C   H   O   H \s
       H   M   H   H   M   B \s
       H   M   H   S   O   M \s
      Please enter 4 valid shots
      ---------------------------------------
      ---------------------------------------
      Direction: Top Left is (0,0), move right for (1, 0) and move down for (0, 1)
      Opponent's Board:\s
       M   M   O   O   O   O \s
       H   H   O   H   H   M \s
       H   H   H   H   H   H \s
       H   M   O   O   O   H \s
       H   M   M   M   M   M \s
       H   M   M   M   M   M \s
      Your Board:\s
       M   M   H   O   M   H \s
       M   M   H   M   M   B \s
       D   O   C   M   O   H \s
       H   M   H   H   O   H \s
       H   M   H   H   M   B \s
       H   M   H   S   O   M \s
      Please enter 4 valid shots
      ---------------------------------------
      ---------------------------------------
      Direction: Top Left is (0,0), move right for (1, 0) and move down for (0, 1)
      Opponent's Board:\s
       M   M   M   M   O   O \s
       H   H   H   H   H   M \s
       H   H   H   H   H   H \s
       H   M   H   O   O   H \s
       H   M   M   M   M   M \s
       H   M   M   M   M   M \s
      Your Board:\s
       M   M   H   O   M   H \s
       M   M   H   M   M   B \s
       D   O   H   M   O   H \s
       H   M   H   H   O   H \s
       H   M   H   H   M   B \s
       H   M   H   S   M   M \s
      Please enter 3 valid shots
      ---------------------------------------
      You Won! :)""";

  /**
   * Game for when user lost against Ai player
   */
  public static String userLost = """
      Hello! Welcome to the OOD BattleSalvo Game!
      Please enter a valid height and width below
      ---------------------------------------
      ---------------------------------------
      Uh Oh! You've entered invalid dimensions.\s
      Please remember that the height and width of the game
      must be in the range (6, 15), inclusive.
      Try again!
      ---------------------------------------
      Please enter your fleet in the order [Carrier, Battleship, Destroyer, Submarine].
      Remember, your fleet may not exceed size 6
      ---------------------------------------
      ---------------------------------------
      Uh Oh! You've entered invalid fleet sizes.
      Please enter your fleet in the order [Carrier, Battleship, Destroyer, Submarine].
      Try again!
      Remember, your fleet may not exceed size 6
      ---------------------------------------
      Direction: Top Left is (0,0), move right for (1, 0) and move down for (0, 1)
      Opponent's Board:\s
       O   O   O   O   O   O \s
       O   O   O   O   O   O \s
       O   O   O   O   O   O \s
       O   O   O   O   O   O \s
       O   O   O   O   O   O \s
       O   O   O   O   O   O \s
      Your Board:\s
       O   C   O   O   O   D \s
       B   C   O   O   O   D \s
       B   C   S   S   S   D \s
       B   C   O   O   O   D \s
       B   C   O   O   O   O \s
       B   C   O   O   O   O \s
      Please enter 4 valid shots
      ---------------------------------------
      ---------------------------------------
      Direction: Top Left is (0,0), move right for (1, 0) and move down for (0, 1)
      Opponent's Board:\s
       O   O   O   O   O   O \s
       O   O   O   O   O   O \s
       H   H   O   O   O   O \s
       O   O   O   O   O   O \s
       O   M   O   O   O   O \s
       M   O   O   O   O   O \s
      Your Board:\s
       O   C   O   O   O   D \s
       B   C   O   M   O   D \s
       B   H   S   S   S   D \s
       B   C   O   O   O   D \s
       H   C   O   O   O   O \s
       B   C   M   O   O   O \s
      Please enter 4 valid shots
      ---------------------------------------
      ---------------------------------------
      Direction: Top Left is (0,0), move right for (1, 0) and move down for (0, 1)
      Opponent's Board:\s
       O   O   O   O   O   O \s
       O   O   O   O   O   O \s
       H   H   H   O   O   O \s
       O   O   O   O   O   O \s
       O   M   M   O   O   O \s
       M   M   M   O   O   O \s
      Your Board:\s
       O   C   O   O   O   H \s
       B   C   O   M   O   D \s
       B   H   S   S   H   D \s
       B   C   O   O   O   D \s
       H   C   O   O   O   O \s
       B   H   M   M   O   O \s
      Please enter 4 valid shots
      ---------------------------------------
      ---------------------------------------
      Direction: Top Left is (0,0), move right for (1, 0) and move down for (0, 1)
      Opponent's Board:\s
       O   O   O   O   O   O \s
       O   O   O   H   O   O \s
       H   H   H   H   O   O \s
       O   O   O   O   O   O \s
       O   M   M   M   O   O \s
       M   M   M   M   O   O \s
      Your Board:\s
       O   C   O   M   O   H \s
       B   C   O   M   O   D \s
       B   H   S   H   H   H \s
       B   C   O   O   M   D \s
       H   C   O   O   O   O \s
       B   H   M   M   O   O \s
      Please enter 4 valid shots
      ---------------------------------------
      ---------------------------------------
      Direction: Top Left is (0,0), move right for (1, 0) and move down for (0, 1)
      Opponent's Board:\s
       O   O   O   O   O   O \s
       O   O   O   H   M   O \s
       H   H   H   H   H   O \s
       O   O   O   O   O   O \s
       O   M   M   M   H   O \s
       M   M   M   M   H   O \s
      Your Board:\s
       O   C   O   M   M   H \s
       B   C   O   M   O   D \s
       B   H   H   H   H   H \s
       H   C   O   O   M   D \s
       H   C   O   O   M   O \s
       B   H   M   M   O   O \s
      Please enter 3 valid shots
      ---------------------------------------
      ---------------------------------------
      Direction: Top Left is (0,0), move right for (1, 0) and move down for (0, 1)
      Opponent's Board:\s
       O   O   O   O   O   O \s
       O   O   O   H   M   H \s
       H   H   H   H   H   H \s
       O   O   O   O   O   H \s
       O   M   M   M   H   O \s
       M   M   M   M   H   O \s
      Your Board:\s
       M   C   O   M   M   H \s
       B   C   O   M   M   D \s
       B   H   H   H   H   H \s
       H   C   O   O   M   D \s
       H   C   O   O   M   M \s
       B   H   M   M   O   O \s
      Please enter 3 valid shots
      ---------------------------------------
      ---------------------------------------
      Direction: Top Left is (0,0), move right for (1, 0) and move down for (0, 1)
      Opponent's Board:\s
       M   O   O   O   O   O \s
       O   O   O   H   M   H \s
       H   H   H   H   H   H \s
       O   O   O   O   O   H \s
       O   M   M   M   H   H \s
       M   M   M   M   H   H \s
      Your Board:\s
       M   C   O   M   M   H \s
       B   H   O   M   M   D \s
       B   H   H   H   H   H \s
       H   C   M   M   M   D \s
       H   C   O   O   M   M \s
       B   H   M   M   O   O \s
      Please enter 3 valid shots
      ---------------------------------------
      ---------------------------------------
      Direction: Top Left is (0,0), move right for (1, 0) and move down for (0, 1)
      Opponent's Board:\s
       M   O   O   O   O   O \s
       H   O   O   H   M   H \s
       H   H   H   H   H   H \s
       M   O   O   O   O   H \s
       M   M   M   M   H   H \s
       M   M   M   M   H   H \s
      Your Board:\s
       M   C   O   M   M   H \s
       B   H   M   M   M   H \s
       B   H   H   H   H   H \s
       H   C   M   M   M   D \s
       H   C   O   O   M   M \s
       B   H   M   M   M   O \s
      Please enter 3 valid shots
      ---------------------------------------
      ---------------------------------------
      Direction: Top Left is (0,0), move right for (1, 0) and move down for (0, 1)
      Opponent's Board:\s
       M   M   O   O   O   O \s
       H   H   O   H   M   H \s
       H   H   H   H   H   H \s
       M   M   O   O   O   H \s
       M   M   M   M   H   H \s
       M   M   M   M   H   H \s
      Your Board:\s
       M   H   O   M   M   H \s
       B   H   M   M   M   H \s
       H   H   H   H   H   H \s
       H   C   M   M   M   D \s
       H   C   O   M   M   M \s
       B   H   M   M   M   O \s
      Please enter 3 valid shots
      ---------------------------------------
      ---------------------------------------
      Direction: Top Left is (0,0), move right for (1, 0) and move down for (0, 1)
      Opponent's Board:\s
       M   M   M   O   O   O \s
       H   H   H   H   M   H \s
       H   H   H   H   H   H \s
       M   M   M   O   O   H \s
       M   M   M   M   H   H \s
       M   M   M   M   H   H \s
      Your Board:\s
       M   H   O   M   M   H \s
       B   H   M   M   M   H \s
       H   H   H   H   H   H \s
       H   C   M   M   M   H \s
       H   H   M   M   M   M \s
       B   H   M   M   M   O \s
      Please enter 2 valid shots
      ---------------------------------------
      ---------------------------------------
      Direction: Top Left is (0,0), move right for (1, 0) and move down for (0, 1)
      Opponent's Board:\s
       M   M   M   M   O   O \s
       H   H   H   H   M   H \s
       H   H   H   H   H   H \s
       M   M   M   M   O   H \s
       M   M   M   M   H   H \s
       M   M   M   M   H   H \s
      Your Board:\s
       M   H   O   M   M   H \s
       H   H   M   M   M   H \s
       H   H   H   H   H   H \s
       H   H   M   M   M   H \s
       H   H   M   M   M   M \s
       B   H   M   M   M   O \s
      Please enter 1 valid shots
      ---------------------------------------
      You Lost :(""";

  /**
   * Game for when user tied with AiUser
   */
  public static String userTie = """
      Hello! Welcome to the OOD BattleSalvo Game!
      Please enter a valid height and width below
      ---------------------------------------
      ---------------------------------------
      Uh Oh! You've entered invalid dimensions.\s
      Please remember that the height and width of the game
      must be in the range (6, 15), inclusive.
      Try again!
      ---------------------------------------
      Please enter your fleet in the order [Carrier, Battleship, Destroyer, Submarine].
      Remember, your fleet may not exceed size 6
      ---------------------------------------
      ---------------------------------------
      Uh Oh! You've entered invalid fleet sizes.
      Please enter your fleet in the order [Carrier, Battleship, Destroyer, Submarine].
      Try again!
      Remember, your fleet may not exceed size 6
      Tied""";
}
