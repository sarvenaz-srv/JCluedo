package com.company.Model.Game;

import com.company.Model.Card.Place;
import com.company.Model.Card.Suspect;
import com.company.Model.Card.Tool;
import com.company.Model.GameBoard.Directions;
import com.company.Model.GameBoard.Location;
import com.company.Model.Player.Player;

import java.util.Random;

public class GameManager {

    public boolean play (Player player)
    {
        boolean isGameFinished = false;
        return isGameFinished;
    }

    public void move(Player player, Directions direction, int numberOfSteps) throws InvalidMoveException{
        Location current = player.getLocation();
        Location next = null;
        //vertical
        if(direction == Directions.UP || direction == Directions.DOWN){
           int y;
            if(direction == Directions.UP){
               y = player.getLocation().getY() + numberOfSteps;
           }
           else{
               y = player.getLocation().getY() - numberOfSteps;
           }
           if(validIndex(y)){
               next = new Location(current.getX(), y);
           }
        }
        //horizontal
        else if(direction == Directions.LEFT || direction == Directions.RIGHT){
            int x;
            if(direction == Directions.LEFT){
                x = player.getLocation().getX() - numberOfSteps;
            }
            else{
                x = player.getLocation().getX() + numberOfSteps;
            }
            if(validIndex(x)){
                next = new Location(x, current.getY());
            }
        }
        if(next == null){
            throw new InvalidMoveException("Out of bounds");
        }
        else {
            if(SharedData.getInstance().gameBoard.isFull(next)){
                throw new InvalidMoveException("This block is full");
            }
            else {
                SharedData.getInstance().gameBoard.setFull(false, current);
                SharedData.getInstance().gameBoard.setFull(true, next);
                player.setLocation(next);
            }
         }
    }

    public boolean correctGuess(Suspect suspect, Tool tool, Place place){
        return suspect.equals(SharedData.getInstance().murderSuspect) && tool.equals(SharedData.getInstance().murderWeapon) && place.equals(SharedData.getInstance().murderPlace);
    }

    public int rollTheDice(){
        Random random = new Random();
        return random.nextInt(6)+1;
    }

    private boolean validIndex(int index){
        return index >= 0 && index < SharedData.getInstance().BOARD_SIZE;
    }
}
