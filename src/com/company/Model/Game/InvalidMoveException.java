package com.company.Model.Game;

public class InvalidMoveException extends Exception {
    InvalidMoveException(String message){
        super(message);
    }
}
