package com.tictactoe.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@AllArgsConstructor
@Getter
public abstract class Player {
    protected Symbol symbol;
    public abstract Cell play(Board board);

}
