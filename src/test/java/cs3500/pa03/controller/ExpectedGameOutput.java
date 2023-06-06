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
       O   O   O   O   O   O \s
       C   C   C   C   C   C \s
       B   B   B   B   B   O \s
       O   O   O   O   O   O \s
       O   D   D   D   D   O \s
       O   O   O   S   S   S \s
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
       O   M   O   O   O   O \s
       C   C   C   C   C   C \s
       B   B   B   B   B   O \s
       O   O   O   O   M   O \s
       O   D   D   H   D   O \s
       O   O   O   H   S   S \s
      Please enter 4 valid shots
      ---------------------------------------
      ---------------------------------------
      Direction: Top Left is (0,0), move right for (1, 0) and move down for (0, 1)
      Opponent's Board:\s
       O   O   O   O   O   O \s
       O   O   O   O   O   O \s
       H   H   H   O   O   O \s
       O   O   O   O   O   O \s
       O   M   H   O   O   O \s
       H   H   H   O   O   O \s
      Your Board:\s
       O   M   O   O   O   O \s
       C   C   C   C   H   H \s
       B   H   B   B   B   O \s
       O   O   M   O   M   O \s
       O   D   D   H   D   O \s
       O   O   O   H   S   S \s
      Please enter 4 valid shots
      ---------------------------------------
      ---------------------------------------
      Direction: Top Left is (0,0), move right for (1, 0) and move down for (0, 1)
      Opponent's Board:\s
       O   O   O   O   O   O \s
       O   O   O   H   O   O \s
       H   H   H   H   O   O \s
       O   O   O   O   O   O \s
       O   M   H   H   O   O \s
       H   H   H   H   O   O \s
      Your Board:\s
       O   M   O   M   O   O \s
       H   C   C   C   H   H \s
       B   H   B   H   H   O \s
       O   O   M   O   M   O \s
       O   D   D   H   D   O \s
       O   O   O   H   S   S \s
      Please enter 4 valid shots
      ---------------------------------------
      ---------------------------------------
      Direction: Top Left is (0,0), move right for (1, 0) and move down for (0, 1)
      Opponent's Board:\s
       O   O   O   O   O   O \s
       O   O   O   H   M   O \s
       H   H   H   H   H   O \s
       O   O   O   O   O   O \s
       O   M   H   H   H   O \s
       H   H   H   H   H   O \s
      Your Board:\s
       O   M   O   M   M   O \s
       H   C   C   C   H   H \s
       B   H   B   H   H   O \s
       O   O   M   O   M   O \s
       O   D   H   H   H   O \s
       O   O   O   H   S   H \s
      Please enter 4 valid shots
      ---------------------------------------
      ---------------------------------------
      Direction: Top Left is (0,0), move right for (1, 0) and move down for (0, 1)
      Opponent's Board:\s
       O   O   O   O   O   O \s
       O   O   O   H   M   M \s
       H   H   H   H   H   M \s
       O   O   O   O   O   M \s
       O   M   H   H   H   H \s
       H   H   H   H   H   O \s
      Your Board:\s
       O   M   O   M   M   O \s
       H   C   C   C   H   H \s
       H   H   B   H   H   O \s
       O   O   M   O   M   O \s
       O   H   H   H   H   O \s
       O   M   O   H   S   H \s
      Please enter 3 valid shots
      ---------------------------------------
      ---------------------------------------
      Direction: Top Left is (0,0), move right for (1, 0) and move down for (0, 1)
      Opponent's Board:\s
       M   O   O   O   O   O \s
       M   O   O   H   M   M \s
       H   H   H   H   H   M \s
       O   O   O   O   O   M \s
       O   M   H   H   H   H \s
       H   H   H   H   H   H \s
      Your Board:\s
       O   M   O   M   M   O \s
       H   C   H   H   H   H \s
       H   H   B   H   H   O \s
       O   O   M   O   M   O \s
       O   H   H   H   H   O \s
       O   M   O   H   S   H \s
      Please enter 3 valid shots
      ---------------------------------------
      ---------------------------------------
      Direction: Top Left is (0,0), move right for (1, 0) and move down for (0, 1)
      Opponent's Board:\s
       M   M   O   O   O   O \s
       M   O   O   H   M   M \s
       H   H   H   H   H   M \s
       M   O   O   O   O   M \s
       M   M   H   H   H   H \s
       H   H   H   H   H   H \s
      Your Board:\s
       O   M   O   M   M   O \s
       H   C   H   H   H   H \s
       H   H   B   H   H   M \s
       O   O   M   O   M   O \s
       O   H   H   H   H   O \s
       O   M   O   H   S   H \s
      Please enter 3 valid shots
      ---------------------------------------
      ---------------------------------------
      Direction: Top Left is (0,0), move right for (1, 0) and move down for (0, 1)
      Opponent's Board:\s
       M   M   M   O   O   O \s
       M   H   O   H   M   M \s
       H   H   H   H   H   M \s
       M   M   O   O   O   M \s
       M   M   H   H   H   H \s
       H   H   H   H   H   H \s
      Your Board:\s
       O   M   O   M   M   O \s
       H   C   H   H   H   H \s
       H   H   B   H   H   M \s
       O   O   M   M   M   O \s
       O   H   H   H   H   O \s
       O   M   O   H   S   H \s
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
       O   S   S   S   O   O \s
       O   O   O   O   O   O \s
       C   C   C   C   C   C \s
       O   D   D   D   D   O \s
       O   O   O   O   O   O \s
       O   B   B   B   B   B \s
      Please enter 4 valid shots
      ---------------------------------------
      ---------------------------------------
      Direction: Top Left is (0,0), move right for (1, 0) and move down for (0, 1)
      Opponent's Board:\s
       H   O   O   O   O   O \s
       O   O   O   O   O   O \s
       H   O   O   O   O   O \s
       M   O   O   O   O   O \s
       O   O   O   O   O   O \s
       O   O   O   O   O   M \s
      Your Board:\s
       O   S   S   S   O   O \s
       O   O   O   O   O   O \s
       C   C   C   C   C   C \s
       M   D   H   D   D   O \s
       O   O   O   O   M   M \s
       O   B   B   B   B   B \s
      Please enter 4 valid shots
      ---------------------------------------
      ---------------------------------------
      Direction: Top Left is (0,0), move right for (1, 0) and move down for (0, 1)
      Opponent's Board:\s
       H   H   O   O   O   O \s
       O   H   O   O   O   O \s
       H   O   O   O   O   O \s
       M   O   O   O   O   O \s
       M   O   O   O   O   O \s
       M   O   O   O   O   M \s
      Your Board:\s
       O   S   S   S   M   O \s
       O   O   M   O   O   O \s
       C   C   C   C   C   C \s
       M   H   H   D   D   M \s
       O   O   O   O   M   M \s
       O   B   B   B   B   B \s
      Please enter 4 valid shots
      ---------------------------------------
      ---------------------------------------
      Direction: Top Left is (0,0), move right for (1, 0) and move down for (0, 1)
      Opponent's Board:\s
       H   H   O   O   O   O \s
       O   H   O   O   O   O \s
       H   H   O   O   O   O \s
       M   M   O   O   O   O \s
       M   M   O   O   O   O \s
       M   M   O   O   O   M \s
      Your Board:\s
       O   S   H   H   M   O \s
       O   O   M   M   O   O \s
       C   C   C   C   C   C \s
       M   H   H   D   D   M \s
       O   O   O   O   M   M \s
       O   B   B   B   B   H \s
      Please enter 4 valid shots
      ---------------------------------------
      ---------------------------------------
      Direction: Top Left is (0,0), move right for (1, 0) and move down for (0, 1)
      Opponent's Board:\s
       H   H   O   O   O   O \s
       O   H   O   O   O   O \s
       H   H   O   O   O   O \s
       M   M   O   O   O   O \s
       M   M   O   O   O   O \s
       M   M   O   O   O   M \s
      Your Board:\s
       O   S   H   H   M   O \s
       O   O   M   M   O   O \s
       C   C   C   C   C   C \s
       M   H   H   D   D   M \s
       O   O   O   O   M   M \s
       O   B   B   B   B   H \s
      Please enter 4 valid shots
      ---------------------------------------
      ---------------------------------------
      Direction: Top Left is (0,0), move right for (1, 0) and move down for (0, 1)
      Opponent's Board:\s
       H   H   O   H   O   O \s
       O   H   O   M   O   O \s
       H   H   O   O   O   O \s
       M   M   O   O   O   O \s
       M   M   M   O   O   O \s
       M   M   M   O   O   M \s
      Your Board:\s
       O   S   H   H   M   M \s
       O   O   M   M   O   O \s
       H   C   C   C   C   C \s
       M   H   H   D   D   M \s
       O   O   M   M   M   M \s
       O   B   B   B   B   H \s
      Please enter 4 valid shots
      ---------------------------------------
      ---------------------------------------
      Direction: Top Left is (0,0), move right for (1, 0) and move down for (0, 1)
      Opponent's Board:\s
       H   H   O   H   O   O \s
       O   H   O   M   O   O \s
       H   H   O   H   O   O \s
       M   M   O   H   O   O \s
       M   M   M   M   O   O \s
       M   M   M   M   O   M \s
      Your Board:\s
       O   H   H   H   M   M \s
       O   O   M   M   M   O \s
       H   C   H   H   C   C \s
       M   H   H   D   D   M \s
       O   O   M   M   M   M \s
       O   B   B   B   B   H \s
      Please enter 3 valid shots
      ---------------------------------------
      ---------------------------------------
      Direction: Top Left is (0,0), move right for (1, 0) and move down for (0, 1)
      Opponent's Board:\s
       H   H   O   H   H   O \s
       O   H   O   M   M   O \s
       H   H   O   H   H   O \s
       M   M   O   H   O   O \s
       M   M   M   M   O   O \s
       M   M   M   M   O   M \s
      Your Board:\s
       O   H   H   H   M   M \s
       M   M   M   M   M   O \s
       H   C   H   H   C   C \s
       M   H   H   D   D   M \s
       O   O   M   M   M   M \s
       O   B   H   H   B   H \s
      Please enter 3 valid shots
      ---------------------------------------
      ---------------------------------------
      Direction: Top Left is (0,0), move right for (1, 0) and move down for (0, 1)
      Opponent's Board:\s
       H   H   O   H   H   O \s
       O   H   O   M   M   O \s
       H   H   O   H   H   O \s
       M   M   O   H   H   O \s
       M   M   M   M   M   O \s
       M   M   M   M   M   M \s
      Your Board:\s
       M   H   H   H   M   M \s
       M   M   M   M   M   O \s
       H   H   H   H   C   C \s
       M   H   H   H   H   M \s
       O   O   M   M   M   M \s
       O   B   H   H   B   H \s
      Please enter 2 valid shots
      ---------------------------------------
      ---------------------------------------
      Direction: Top Left is (0,0), move right for (1, 0) and move down for (0, 1)
      Opponent's Board:\s
       H   H   O   H   H   M \s
       O   H   O   M   M   M \s
       H   H   O   H   H   O \s
       M   M   O   H   H   O \s
       M   M   M   M   M   O \s
       M   M   M   M   M   M \s
      Your Board:\s
       M   H   H   H   M   M \s
       M   M   M   M   M   M \s
       H   H   H   H   C   C \s
       M   H   H   H   H   M \s
       O   M   M   M   M   M \s
       O   H   H   H   H   H \s
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
