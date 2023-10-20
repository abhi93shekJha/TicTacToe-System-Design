package com.tictactoe.models;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Getter
public class Board {
    List<List<Cell>> cells = new ArrayList<>();
    private int rowSize = 0;
    private int colSize = 0;

    public Board(int size){
        this.rowSize = size;
        this.colSize = size;
        this.cells = initializeCells(size);
    }

    private List<List<Cell>> initializeCells(int n){
        List<Cell> cellList = Collections.nCopies(n, new Cell());
        return Collections.nCopies(n, cellList);
    }

    public boolean isEmpty(Cell cell){
        int row = cell.getRow();
        int column = cell.getColumn();

        return this.getCells().get(row).get(column).symbol==null;

    }
}
