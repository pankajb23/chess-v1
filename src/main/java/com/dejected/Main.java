package com.dejected;

import com.dejected.exception.InValidMoveException;
import com.dejected.exception.NoSoldierPresentException;
import com.dejected.player.Player;
import com.dejected.player.PlayerType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created on 04/02/17 by dark magic.
 */
public class Main {
    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws IOException {
        Player playerWhite = new Player(PlayerType.WHITE, "Pankaj");
        Player playerBlack = new Player(PlayerType.BLACK, "Goku");

        ChessBoard chessBoard = new ChessBoard(playerWhite, playerBlack);

        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        int playerTurn = 0;
        while ((input = buff.readLine()) != null) {
            String[] a = input.split(" ");
            if (checkInput(a)) {
                System.out.println("Wrong input ---------");
                System.out.println("Input should be in Format :- A1 B1");
            } else {
                try {
                    if (playerTurn % 2 == 0) {
                        chessBoard.moveWhitePlayer(getBlockForInputString(a[0]), getBlockForInputString(a[1]));
                    } else {
                        chessBoard.moveBlackPlayer(getBlockForInputString(a[0]), getBlockForInputString(a[1]));
                    }
                    playerTurn++;
                } catch (NoSoldierPresentException ex) {
                    LOG.info("InValid move {}", ex);
                } catch (InValidMoveException ex) {
                    LOG.info("Soldier cann't move to the place ");
                }
            }
        }
    }

    private static Block getBlockForInputString(String s) {
        int row = s.charAt(0) - 'A' + 1;
        int column = s.charAt(1) - '0';
        BlockType blockType;
        if ((row + column) % 2 == 1) {
            blockType = BlockType.WHITE;
        } else {
            blockType = BlockType.BLACK;
        }
        Block block = new Block(row, column, blockType);
        return block;
    }

    private static boolean checkInput(String[] a) {
        boolean flag = true;
        for (int i = 0; i < a.length; i++)
            flag = flag & checkInput(a[i]);
        return flag;
    }

    private static boolean checkInput(String a) {
        if (a.length() != 2) return false;
        if ((a.charAt(0) >= 'A' && a.charAt(0) <= 'H') && (a.charAt(1) >= '1' && a.charAt(1) <= '8')) return true;
        return false;
    }
}
