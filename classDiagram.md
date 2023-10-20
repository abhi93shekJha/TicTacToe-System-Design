classDiagram
Game : -Board board
Game : -Player[] players
Game --* Board
Game --* Player
Game : startGame()
Game : makeMove()
Game : Player checkWinner()
Game : registerPlayer()
class Board{
-Cell[][] cells
}
Board --* Cell
class Cell{
-int row
-int col
-Symbol symbol
}
class Player{
<<abstract>>
-Symbol symbol
+play(Board): Cell
}
Player<|--HumanPlayer
Player<|--BotPlayer	 
class HumanPlayer{
-User user
+play(Board): Cell
}
HumanPlayer --*	 User
class User{
-byte[][] profilePic
-String name
-String email
}
class BotPlayer{
-MoveStrategy move
+play(Board): Cell
}
BotPlayer
class MoveStrategy{
<<interface>>
+makeMove(Board): Cell
}
MoveStrategy <|-- RandomMoveStrategy
MoveStrategy <|-- CustomMoveStrategy
BotPlayer --* MoveStrategy
class RandomMoveStrategy{
+makeMove(Board): Cell
}
class CustomMoveStrategy{
+makeMove(Board): Cell
}
