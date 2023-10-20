package com.tictactoe.models;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class BotPlayer extends Player{
    private Level difficultyLevel;
    private MoveStrategy moveStrategy;
    public BotPlayer(Symbol symbol, Level difficultyLevel, MoveStrategy strategy){
        super(symbol);
        this.moveStrategy = strategy;
        this.difficultyLevel = difficultyLevel;
    }
    @Override
    public Cell play(Board board) {
        return moveStrategy.makeMove(board);
    }
}
