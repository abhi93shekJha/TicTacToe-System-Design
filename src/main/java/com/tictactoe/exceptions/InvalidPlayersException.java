package com.tictactoe.exceptions;

public class InvalidPlayersException extends RuntimeException{
    public InvalidPlayersException(String message){
        super(message);
    }
}
