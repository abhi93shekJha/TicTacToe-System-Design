package com.tictactoe.models;

import com.tictactoe.exceptions.InvalidMoveException;
import com.tictactoe.exceptions.InvalidPlayersException;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Getter
public class Game {
    private static final int PLAYER_SIZE = 2;
    private static final GameStatus DEFAULT_STATUS = GameStatus.IN_PROGRESS;
    private GameStatus gameStatus;
    private Board board;
    private List<Player> players = new ArrayList<>();
    private int nextPlayerIndex = 0;

    // private constructor to facilitate builder pattern
    private Game(){}
    public static GameBuilder build(){
        return new GameBuilder();
    }
    public void makeMove(){

        // get next player, play the move, validate the new cell
        Cell nextMove = getNextMove();
        nextPlayerIndex = 1-nextPlayerIndex;

        // Update the board



    }

    private Cell getNextMove(){
        Player player = players.get(nextPlayerIndex);
        Cell cell = player.play(board);
        boolean validCell = validateMove(cell);
        if(!validCell)
            throw new InvalidMoveException("Wrong move inserted");
        return cell;

    }
    private boolean validateMove(Cell cell){
        int row = cell.getRow();
        int column = cell.getColumn();
        if(row<0||column<0)
            return false;

        if(row<board.getRowSize() && column<board.getColSize()) {
            return board.isEmpty(cell);
        }
        else
            return false;
    }

    public static class GameBuilder{

        private Game game;
        public GameBuilder(){
            game = new Game();
        }
        public GameBuilder withBoardSize(int size){
            game.board = new Board(size);
            return this;
        }
        public GameBuilder withPlayer(Player player){
            game.players.add(player);
            return this;
        }
        public Game build(){
            boolean isValid = validate();
            if(!isValid)
                throw new InvalidPlayersException("Invalid list of players!");
            Game newGame = new Game();
            newGame.players = game.players;
            newGame.board = game.board;
            newGame.gameStatus = DEFAULT_STATUS;

            return newGame;
        }
        private boolean validate(){
            if (game.players.size()!=PLAYER_SIZE){
                return false;
            }
            int symbolSize = 0;
            Set<Symbol> symbols = new HashSet<>();
            for(Player player:game.players)
                symbols.add(player.getSymbol());
            return symbols.size()==PLAYER_SIZE;
        }
    }
}
