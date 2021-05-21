package org.ta.jcluedo.view;

import org.ta.jcluedo.model.elements.board.Block;
import org.ta.jcluedo.model.elements.cards.Card;
import org.ta.jcluedo.model.elements.player.Player;
import org.ta.jcluedo.model.utils.SharedData;

import java.util.ArrayList;

/**
 * This Class Print the Game on Console
 */
public class GameFrame {

    private SharedData sharedData;
    private char escCode;

    public GameFrame() {
        sharedData = SharedData.getInstance();
        escCode = sharedData.ESC_CODE;
    }

    /**
     * Draw Map and Player stats
     * {@link #drawCards(Player, int)}
     * {@link #drawPlayers()}
     */
    public void draw() {
        drawMap();
        drawPlayers();
    }

    /**
     * Draw All Blocks of Map
     */
    private void drawMap() {
        Block[][] blocks = sharedData.gameBoard.getBlocks();

        for (int i = 0; i < sharedData.BOARD_SIZE; i++) {
            for (int j = 0; j < sharedData.BOARD_SIZE; j++) {
                if (sharedData.gameBoard.isRoom(blocks[j][i].getLocation())) { // in case it was a Room
                    drawBlock(blocks[j][i], 7, 2);
                    continue;
                }
                drawBlock(blocks[j][i], 6, 2);
            }
        }

        for (int i = 0; i < sharedData.BOARD_SIZE; i++) {
            for (int j = 0; j < sharedData.BOARD_SIZE; j++) {
                if (sharedData.gameBoard.isRoom(blocks[j][i].getLocation())) { // in case it was a Room
                    drawBlock(sharedData.gameBoard.getRooms()
                            .get(blocks[j][i]).getDoor(), 7, 2,"-D-");

                }
            }
        }
    }

    /**
     * Draw All Players including their cards
     * {@link #drawCards(Player, int)}
     */
    private void drawPlayers() {
        Player[] players = sharedData.players;
        for (int i = 0; i < sharedData.PLAYER_COUNT; i++) {
            Block[][] blocks = sharedData.gameBoard.getBlocks();
            drawBlock(blocks[players[i].getLocation().getX()][players[i].getLocation().getY()],
                    players[i].getCOLOR().ordinal(), 2);

            System.out.print(String.format("%c[%dm", escCode, 0)); // reset
            System.out.print(String.format("%c[%dm", escCode, players[i].getCOLOR().ordinal() + 30));
            System.out.print(String.format("%c[%d;%df%s", escCode, 5 + i * 10,
                    ((sharedData.BOARD_SIZE + 2) * 5) + 10
                    , players[i].getNAME())); // set cursor location
            drawCards(players[i], i);

            System.out.print(String.format("%c[%dm", escCode, 0)); // reset
            System.out.println();
        }


    }

    /**
     * Draw player card
     *
     * @param offset is the location of first card
     */
    private void drawCards(Player player, int offset) {
        ArrayList<Card> cards = player.getHand();
        int color = player.getCOLOR().ordinal();
        int i = 0;
        for (Card card : cards) {
            System.out.print(String.format("%c[%dm", escCode, color + 31));
            for (int k = 0; k < 8; k++) {
                System.out.print(String.format("%c[%d;%df", escCode, 7 + offset * 10 + k,
                        ((sharedData.BOARD_SIZE + 2) * 5) + 11 + 13 * i)); // set cursor location
                if (k == 4) {
                    System.out.print(String.format("%c[%dm%s", escCode, 40 + color, card.getNAME()));

                    for (int j = 0; j < 12 - card.getNAME().length(); j++)
                        System.out.print(String.format("%c[%dm ", escCode, 40 + color));
                    continue;
                }
                System.out.print(String.format("%c[%dm            ", escCode, 40 + color));
            }
            i++;
        }

    }

    /**
     * Draw a single Block
     *
     * @param block
     * @param color
     * @param length
     */
    private void drawBlock(Block block, int color, int length) {
        int number = 5;
        int x = (block.getLocation().getX()) * 5 + 10;
        int y = (block.getLocation().getY()) * 3 + 3;

        for (int i = 0; i <= length - 1; i++) {

            System.out.print(String.format("%c[%d;%df", escCode, y + i + 1, x + 1)); // set cursor location
            for (int j = 0; j < 2 * length; j++) {
                System.out.print(String.format("%c[%dm ", escCode, 40 + color));
            }
        }
        System.out.println();
    }


    /**
     * Draw a single Block with a text
     *
     * @param block
     * @param color
     * @param length
     * @param text   of block
     */
    private void drawBlock(Block block, int color, int length, String text) {
        int number = 5;
        int x = (block.getLocation().getX()) * 5 + 10;
        int y = (block.getLocation().getY()) * 3 + 3;

        for (int i = 0; i <= length - 1; i++) {

            System.out.print(String.format("%c[%d;%df", escCode, y + i + 1, x + 1)); // set cursor location

            if (i == 1) {
                System.out.print(String.format("%c[%dm%s ", escCode, 40 + color, text));
                continue;
            }

            System.out.print(String.format("%c[%dm    ", escCode, 40 + color));
        }
        System.out.println();
    }
}
