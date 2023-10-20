package com.tictactoe.models;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class HumanPlayer extends Player{
    private User user;
    public HumanPlayer(Symbol symbol, User user){
        super(symbol);
        this.user = user;
    }
    @Override
    public Cell play(Board board) {
        return null;
    }
}
