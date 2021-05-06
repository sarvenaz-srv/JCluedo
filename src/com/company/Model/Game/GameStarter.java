package com.company.Model.Game;

import com.company.Model.Card.*;

import java.util.ArrayList;
import java.util.Arrays;

public class GameStarter {
    private GameLoop gameLoop;
    private CardDeck cardDeck;

    public void gameInit()
    {
        cardInit();
        playersInit();
        boardInit();
    }

    public void playersInit()
    {

    }

    public void boardInit()
    {

    }

    public void cardInit()
    {
        ArrayList<Card> cards = new ArrayList<>(Arrays.asList(
           new Place(References.RoomType.BATHROOM.toString(), References.RoomType.BATHROOM),
           new Place(References.RoomType.BEDROOM.toString(), References.RoomType.BEDROOM),
           new Place(References.RoomType.KITCHEN.toString(), References.RoomType.KITCHEN),
           new Place(References.RoomType.COURTYARD.toString(), References.RoomType.COURTYARD),
           new Place(References.RoomType.DINING.toString(), References.RoomType.DINING),
           new Place(References.RoomType.GARAGE.toString(), References.RoomType.GARAGE),
           new Place(References.RoomType.GAME.toString(), References.RoomType.GAME),
           new Place(References.RoomType.STUDY.toString(), References.RoomType.STUDY),
           new Place(References.RoomType.LIVING.toString(), References.RoomType.LIVING),
           new Suspect(References.Character.GREEN.toString(), References.Character.GREEN),
           new Suspect(References.Character.WHITE.toString(), References.Character.WHITE),
           new Suspect(References.Character.MUSTARD.toString(), References.Character.MUSTARD),
           new Suspect(References.Character.SCARLET.toString(), References.Character.SCARLET),
           new Suspect(References.Character.PEACOCK.toString(), References.Character.PEACOCK),
           new Suspect(References.Character.PLUM.toString(), References.Character.PLUM),
           new Tool(References.Weapons.CANDLESTICK.toString(), References.Weapons.CANDLESTICK),
           new Tool(References.Weapons.DAGGER.toString(), References.Weapons.DAGGER),
           new Tool(References.Weapons.PIPE.toString(), References.Weapons.PIPE),
           new Tool(References.Weapons.PISTOL.toString(), References.Weapons.PISTOL),
           new Tool(References.Weapons.ROPE.toString(), References.Weapons.ROPE),
           new Tool(References.Weapons.WRENCH.toString(), References.Weapons.WRENCH)
        ));
        SharedData.getInstance().cardDeck = new CardDeck(cards);
        SharedData.getInstance().cardDeck.shuffle();
    }
}
