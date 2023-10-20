package com.tictactoe.models;

import lombok.Getter;

@Getter
public class Cell {
    private int row, column;
    Symbol symbol;
}
