
# TicTacToe game system design

## Requirements list:

1. It will have a game board.
2. A user can register and start the game.
3. A board can have n*n cells.
4. Two players can play the game.
5. Human Player will have name, email and profile picture.
6. A bot will have difficulty level.
7. A human user will start the game.
8. Both players will be assigned a symbol by default.
9. A bot can also be an other player.
10. Both players will take turns one after another.
11. The game can be won or it can be a draw.

## Classes
1. Game - startGame, registerPlayer
2. Board - Cells[][] cells
3. Cell - row, column, symbol
4. Symbol (enum) - X, O
5. Player (abstract class)
6. HumanPlayer-name, email, profilePic 
    (flyweight design pattern to minimise excess memory usage)- create separate "User" class
7. BotPlayer - difficulty levels (enum)
    (Strategy Design pattern)-makeMove
8. MoveStrategy (inteface)
9. RandomStrategy
10. CustomStrategy    
11. DifficultyLevel (enum) - EASY, MEDIUM, HARD
  
