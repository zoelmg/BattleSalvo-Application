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
       O   C   O   O   M   D \s
       B   C   M   O   O   D \s
       B   C   S   S   S   H \s
       B   H   O   O   O   D \s
       B   C   O   O   O   O \s
       B   C   O   O   O   O \s
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
       O   C   O   O   M   D \s
       B   C   M   O   O   H \s
       B   C   S   S   S   H \s
       B   H   O   O   O   H \s
       B   C   M   O   O   O \s
       H   C   O   O   O   O \s
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
       O   C   O   O   M   D \s
       B   C   M   O   O   H \s
       B   C   S   S   S   H \s
       H   H   M   O   O   H \s
       B   C   M   M   O   O \s
       H   C   M   O   O   O \s
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
       O   C   O   M   M   D \s
       B   C   M   O   O   H \s
       B   C   H   S   S   H \s
       H   H   M   O   O   H \s
       H   C   M   M   M   O \s
       H   C   M   O   O   O \s
      Please enter 4 valid shots
      ---------------------------------------
      ---------------------------------------
      Direction: Top Left is (0,0), move right for (1, 0) and move down for (0, 1)
      Opponent's Board:\s
       O   O   O   O   O   O \s
       O   O   O   H   M   H \s
       H   H   H   H   H   H \s
       O   O   O   O   O   H \s
       O   M   M   M   H   H \s
       M   M   M   M   H   O \s
      Your Board:\s
       M   C   O   M   M   D \s
       B   C   M   O   O   H \s
       B   C   H   S   S   H \s
       H   H   M   O   O   H \s
       H   H   M   M   M   O \s
       H   C   M   O   M   O \s
      Please enter 4 valid shots
      ---------------------------------------
      ---------------------------------------
      Direction: Top Left is (0,0), move right for (1, 0) and move down for (0, 1)
      Opponent's Board:\s
       M   O   O   O   O   O \s
       H   O   O   H   M   H \s
       H   H   H   H   H   H \s
       M   O   O   O   O   H \s
       O   M   M   M   H   H \s
       M   M   M   M   H   H \s
      Your Board:\s
       M   C   O   M   M   D \s
       B   H   M   O   O   H \s
       B   C   H   H   S   H \s
       H   H   M   M   O   H \s
       H   H   M   M   M   O \s
       H   C   M   O   M   O \s
      Please enter 4 valid shots
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
       M   C   O   M   M   D \s
       B   H   M   O   O   H \s
       B   H   H   H   S   H \s
       H   H   M   M   O   H \s
       H   H   M   M   M   M \s
       H   H   M   O   M   O \s
      Please enter 4 valid shots
      ---------------------------------------
      ---------------------------------------
      Direction: Top Left is (0,0), move right for (1, 0) and move down for (0, 1)
      Opponent's Board:\s
       M   M   M   M   O   O \s
       H   H   H   H   M   H \s
       H   H   H   H   H   H \s
       M   M   M   O   O   H \s
       M   M   M   M   H   H \s
       M   M   M   M   H   H \s
      Your Board:\s
       M   C   M   M   M   D \s
       H   H   M   O   O   H \s
       B   H   H   H   S   H \s
       H   H   M   M   M   H \s
       H   H   M   M   M   M \s
       H   H   M   O   M   O \s
      Please enter 4 valid shots
      ---------------------------------------
      You Won! :)""";

  /**
   * Game for when user lost against Ai player
   */
  public static String userLost = """
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
       M   M   O   O   O   O \s
       O   H   O   O   O   O \s
       O   H   O   O   O   O \s
       O   O   O   O   O   O \s
       O   O   O   O   O   O \s
       O   O   O   O   O   O \s
      Your Board:\s
       O   O   C   O   O   B \s
       O   O   C   O   O   H \s
       H   O   C   O   O   H \s
       D   O   C   S   O   B \s
       D   O   C   S   O   B \s
       H   O   C   S   O   O \s
      Please enter 4 valid shots
      ---------------------------------------
      ---------------------------------------
      Direction: Top Left is (0,0), move right for (1, 0) and move down for (0, 1)
      Opponent's Board:\s
       M   M   M   O   O   O \s
       O   H   O   O   O   O \s
       O   H   O   O   O   O \s
       O   M   O   O   O   O \s
       O   M   O   O   O   O \s
       O   M   O   O   O   O \s
      Your Board:\s
       O   O   C   O   M   H \s
       O   O   C   O   M   H \s
       H   O   C   O   O   H \s
       D   O   H   S   O   B \s
       D   O   C   S   O   B \s
       H   O   C   S   O   O \s
      Please enter 4 valid shots
      ---------------------------------------
      ---------------------------------------
      Direction: Top Left is (0,0), move right for (1, 0) and move down for (0, 1)
      Opponent's Board:\s
       M   M   M   M   O   O \s
       O   H   O   O   O   O \s
       O   H   H   O   O   O \s
       O   M   O   O   O   O \s
       O   M   O   M   O   O \s
       O   M   O   M   O   O \s
      Your Board:\s
       O   O   C   O   M   H \s
       O   O   C   O   M   H \s
       H   M   C   O   M   H \s
       D   O   H   H   O   B \s
       D   O   C   S   O   B \s
       H   O   C   S   O   M \s
      Please enter 4 valid shots
      ---------------------------------------
      ---------------------------------------
      Direction: Top Left is (0,0), move right for (1, 0) and move down for (0, 1)
      Opponent's Board:\s
       M   M   M   M   M   M \s
       O   H   O   O   O   O \s
       O   H   H   O   O   O \s
       O   M   O   O   O   O \s
       O   M   O   M   M   O \s
       O   M   O   M   M   O \s
      Your Board:\s
       M   M   C   O   M   H \s
       O   M   C   O   M   H \s
       H   M   C   O   M   H \s
       D   O   H   H   M   B \s
       D   O   C   S   O   B \s
       H   O   C   S   O   M \s
      Please enter 4 valid shots
      ---------------------------------------
      ---------------------------------------
      Direction: Top Left is (0,0), move right for (1, 0) and move down for (0, 1)
      Opponent's Board:\s
       M   M   M   M   M   M \s
       O   H   O   O   O   M \s
       H   H   H   O   O   O \s
       O   M   O   O   O   O \s
       O   M   O   M   M   M \s
       O   M   O   M   M   M \s
      Your Board:\s
       M   M   C   M   M   H \s
       O   M   C   O   M   H \s
       H   M   C   O   M   H \s
       D   O   H   H   M   B \s
       H   M   C   S   M   B \s
       H   O   C   S   O   M \s
      Please enter 4 valid shots
      ---------------------------------------
      ---------------------------------------
      Direction: Top Left is (0,0), move right for (1, 0) and move down for (0, 1)
      Opponent's Board:\s
       M   M   M   M   M   M \s
       O   H   O   O   O   M \s
       H   H   H   H   O   O \s
       O   M   O   O   O   O \s
       O   M   M   M   M   M \s
       H   M   M   M   M   M \s
      Your Board:\s
       M   M   C   M   M   H \s
       O   M   C   M   M   H \s
       H   M   C   O   M   H \s
       D   M   H   H   M   B \s
       H   M   C   S   M   B \s
       H   O   H   H   O   M \s
      Please enter 4 valid shots
      ---------------------------------------
      ---------------------------------------
      Direction: Top Left is (0,0), move right for (1, 0) and move down for (0, 1)
      Opponent's Board:\s
       M   M   M   M   M   M \s
       H   H   H   O   H   M \s
       H   H   H   H   O   O \s
       H   M   O   O   O   O \s
       O   M   M   M   M   M \s
       H   M   M   M   M   M \s
      Your Board:\s
       M   M   C   M   M   H \s
       M   M   C   M   M   H \s
       H   M   H   M   M   H \s
       D   M   H   H   M   B \s
       H   M   C   S   M   H \s
       H   O   H   H   O   M \s
      Please enter 4 valid shots
      ---------------------------------------
      ---------------------------------------
      Direction: Top Left is (0,0), move right for (1, 0) and move down for (0, 1)
      Opponent's Board:\s
       M   M   M   M   M   M \s
       H   H   H   H   H   M \s
       H   H   H   H   O   O \s
       H   M   O   O   H   H \s
       H   M   M   M   M   M \s
       H   M   M   M   M   M \s
      Your Board:\s
       M   M   C   M   M   H \s
       M   M   H   M   M   H \s
       H   M   H   M   M   H \s
       H   M   H   H   M   H \s
       H   M   C   S   M   H \s
       H   M   H   H   O   M \s
      Please enter 2 valid shots
      ---------------------------------------
      ---------------------------------------
      Direction: Top Left is (0,0), move right for (1, 0) and move down for (0, 1)
      Opponent's Board:\s
       M   M   M   M   M   M \s
       H   H   H   H   H   M \s
       H   H   H   H   H   O \s
       H   M   H   O   H   H \s
       H   M   M   M   M   M \s
       H   M   M   M   M   M \s
      Your Board:\s
       M   M   C   M   M   H \s
       M   M   H   M   M   H \s
       H   M   H   M   M   H \s
       H   M   H   H   M   H \s
       H   M   C   H   M   H \s
       H   M   H   H   M   M \s
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
       O   P   O   O   O   O \s
       O   P   O   O   P   O \s
       P   P   O   P   P   O \s
       P   P   O   P   P   O \s
       P   P   O   P   P   O \s
       P   P   O   O   P   O \s
      Please enter 4 valid shots
      ---------------------------------------
      ---------------------------------------
      Direction: Top Left is (0,0), move right for (1, 0) and move down for (0, 1)
      Opponent's Board:\s
       M   O   O   O   O   O \s
       M   O   O   O   O   O \s
       H   O   O   O   O   O \s
       M   O   O   O   O   O \s
       O   O   O   O   O   O \s
       O   O   O   O   O   O \s
      Your Board:\s
       O   H   O   O   O   O \s
       O   P   O   O   P   O \s
       P   P   O   P   P   O \s
       P   P   O   H   P   O \s
       P   P   M   P   P   O \s
       P   P   O   M   P   O \s
      Please enter 4 valid shots
      ---------------------------------------
      ---------------------------------------
      Direction: Top Left is (0,0), move right for (1, 0) and move down for (0, 1)
      Opponent's Board:\s
       M   M   O   O   O   O \s
       M   M   O   O   O   O \s
       H   O   O   O   O   O \s
       M   O   O   O   O   O \s
       H   O   O   O   O   O \s
       M   O   O   O   O   O \s
      Your Board:\s
       O   H   O   O   M   O \s
       O   P   O   M   P   O \s
       P   P   O   P   P   O \s
       P   P   O   H   H   O \s
       P   P   M   P   P   O \s
       P   H   O   M   P   O \s
      Please enter 4 valid shots
      ---------------------------------------
      ---------------------------------------
      Direction: Top Left is (0,0), move right for (1, 0) and move down for (0, 1)
      Opponent's Board:\s
       M   M   O   O   O   O \s
       M   M   O   O   O   O \s
       H   H   O   O   O   O \s
       M   M   O   O   O   O \s
       H   H   O   O   O   O \s
       M   M   O   O   O   O \s
      Your Board:\s
       O   H   O   O   M   O \s
       O   H   O   M   P   M \s
       P   P   O   P   P   O \s
       H   P   M   H   H   O \s
       P   P   M   P   P   O \s
       P   H   O   M   P   O \s
      Please enter 4 valid shots
      ---------------------------------------
      ---------------------------------------
      Direction: Top Left is (0,0), move right for (1, 0) and move down for (0, 1)
      Opponent's Board:\s
       M   M   M   O   O   O \s
       M   M   M   O   O   O \s
       H   H   H   O   O   O \s
       M   M   M   O   O   O \s
       H   H   O   O   O   O \s
       M   M   O   O   O   O \s
      Your Board:\s
       O   H   O   O   M   O \s
       O   H   O   M   H   M \s
       P   P   O   P   P   M \s
       H   P   M   H   H   M \s
       P   P   M   P   P   O \s
       P   H   O   M   P   M \s
      Please enter 4 valid shots
      ---------------------------------------
      ---------------------------------------
      Direction: Top Left is (0,0), move right for (1, 0) and move down for (0, 1)
      Opponent's Board:\s
       M   M   M   M   O   O \s
       M   M   M   M   O   O \s
       H   H   H   O   O   O \s
       M   M   M   O   O   O \s
       H   H   H   O   O   O \s
       M   M   H   O   O   O \s
      Your Board:\s
       O   H   O   O   M   M \s
       O   H   O   M   H   M \s
       P   P   O   H   P   M \s
       H   P   M   H   H   M \s
       P   P   M   P   H   M \s
       P   H   O   M   P   M \s
      Please enter 4 valid shots
      ---------------------------------------
      ---------------------------------------
      Direction: Top Left is (0,0), move right for (1, 0) and move down for (0, 1)
      Opponent's Board:\s
       M   M   M   M   O   O \s
       M   M   M   M   O   O \s
       H   H   H   H   O   O \s
       M   M   M   H   O   O \s
       H   H   H   H   O   O \s
       M   M   H   H   O   O \s
      Your Board:\s
       M   H   O   O   M   M \s
       O   H   O   M   H   M \s
       H   P   M   H   P   M \s
       H   P   M   H   H   M \s
       P   H   M   P   H   M \s
       P   H   O   M   P   M \s
      Please enter 4 valid shots
      ---------------------------------------
      ---------------------------------------
      Direction: Top Left is (0,0), move right for (1, 0) and move down for (0, 1)
      Opponent's Board:\s
       M   M   M   M   M   O \s
       M   M   M   M   M   O \s
       H   H   H   H   H   O \s
       M   M   M   H   H   O \s
       H   H   H   H   O   O \s
       M   M   H   H   O   O \s
      Your Board:\s
       M   H   O   O   M   M \s
       O   H   M   M   H   M \s
       H   P   M   H   P   M \s
       H   P   M   H   H   M \s
       P   H   M   P   H   M \s
       H   H   M   M   H   M \s
      Please enter 4 valid shots
      ---------------------------------------
      ---------------------------------------
      Direction: Top Left is (0,0), move right for (1, 0) and move down for (0, 1)
      Opponent's Board:\s
       M   M   M   M   M   M \s
       M   M   M   M   M   M \s
       H   H   H   H   H   O \s
       M   M   M   H   H   O \s
       H   H   H   H   H   O \s
       M   M   H   H   H   O \s
      Your Board:\s
       M   H   M   O   M   M \s
       M   H   M   M   H   M \s
       H   P   M   H   H   M \s
       H   H   M   H   H   M \s
       P   H   M   P   H   M \s
       H   H   M   M   H   M \s
      Please enter 3 valid shots
      ---------------------------------------
      ---------------------------------------
      Direction: Top Left is (0,0), move right for (1, 0) and move down for (0, 1)
      Opponent's Board:\s
       M   M   M   M   M   M \s
       M   M   M   M   M   M \s
       H   H   H   H   H   H \s
       M   M   M   H   H   H \s
       H   H   H   H   H   M \s
       M   M   H   H   H   O \s
      Your Board:\s
       M   H   M   M   M   M \s
       M   H   M   M   H   M \s
       H   P   M   H   H   M \s
       H   H   M   H   H   M \s
       H   H   M   H   H   M \s
       H   H   M   M   H   M \s
      Please enter 1 valid shots
      ---------------------------------------
      Tied""";
}
