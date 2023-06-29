# BattleSalvo
## Contributors @ananyaspatil
## How to Play
- when playing solo against AI Player of this program, run the program with no command line arguments.
- when playing on server, include Host then Port in the command line arguments.
- to play against others, join on their Computer's Host address and set Game Mode to "Multi" 
in the code instead of "SINGLE"

## Rules of the Game
- The Manual Player can enter the dimension of the board from 6 to 15 inclusive.
- They must enter valid fleet specification for the game; the total ship amount must be less or equal to 
the smaller dimension of the board
  - The location of the fleet are randomly generated and are both different for each player. 
- The coordinates of the board starts with 0 instead of 1. 
  - The x coordinates goes first then y coordinates goes second seperated by space (ex: 2 0)
  - The x coordinates increases from left to right
  - The y coordinates increases from top to bottom
- For each round, the player has the amount of ship left of their own fleet of shots to fire
  - Players cannot enter any coordinates that have already been previously chosen
  - If there are less available coordinates left on the opponent's board than the amount of ship left
    available, then the player will only have the number of available coordinates of shots
- The player can either win, lose, or tie the game.

## Notes:
- AiPlayer in Model are not completed clean codes; was written under time crunch to compete in
  battle salvo tournament; will be improved

## Acquired Skills:
- Learned how to use Json and Jackson serialization and deserialization using Java Records
- Efficiently using abstraction, delegation, and other SOLID principles
- Programmed Ai Player to efficiently shoot down the other player's boat 
