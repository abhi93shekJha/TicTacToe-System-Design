package com.tictactoe;

import com.tictactoe.models.*;
import com.tictactoe.strategies.RandomMoveStrategy;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGame {

    @Test
    public void testCreateBoard(){
        Board board = new Board(5);
        int rowSize = board.getCells().size();
        int columnSize = board.getCells().get(0).size();
        assertEquals(5, rowSize, "If the board is created with constructor size n, row size should be n");
        assertEquals(5, columnSize, "If the board is created with constructor size n, column size should be n");
    }

    @Test
    public void testCreateGame(){
        Game game = Game.build()
                .withBoardSize(3)
                .withPlayer(
                        HumanPlayer.builder()
                                .symbol(Symbol.X)
                                .user(new User())
                                .build()
                )
                .withPlayer(
                        BotPlayer.builder()
                                .symbol(Symbol.O)
                                .difficultyLevel(Level.EASY)
                                .moveStrategy(new RandomMoveStrategy())
                                .build()
                )
                .build();

        assertEquals(2, game.getPlayers().size(),
                "If game is create is created, it should have two players");

    }

}
