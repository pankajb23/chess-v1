package com.dejected;

import com.dejected.block.Block;
import com.dejected.block.BlockInit;
import com.dejected.exception.InValidMoveException;
import com.dejected.exception.KingCheckException;
import com.dejected.exception.NoKingAvilableException;
import com.dejected.exception.NoSoldierPresentException;
import com.dejected.player.HistoryTuple;
import com.dejected.player.Player;
import com.dejected.soldiers.Soldier;
import com.dejected.soldiers.impl.*;

import java.util.Stack;

/**
 * Created on 04/02/17 by dark magic.
 */
public class ChessBoard {
    private final Player playerWhite;
    private final Player playerBlack;
    private final Block[][] blocks;
    private Stack<HistoryTuple> historyMoves;

    public ChessBoard(Player playerWhite, Player playerBlack) {
        this.playerWhite = playerWhite;
        this.playerBlack = playerBlack;
        historyMoves = new Stack<>();
        blocks = BlockInit.INSTANCE.getBlocks();
    }

    public void playerMove(Block fromBlock, Block toBlock, Player.PlayerType playerType) {
        Block fBlock = blocks[fromBlock.getRowCount()][fromBlock.getColumnCount()];
        Block tBlock = blocks[toBlock.getRowCount()][toBlock.getColumnCount()];

        moveSoldier(fBlock, tBlock, playerType);
    }

    private boolean moveSoldier(Block fromBlock, Block toBlock, Player.PlayerType playerType) {
        Soldier soldier = fromBlock.getSoldier();
        if (soldier == null) {
            throw new NoSoldierPresentException("No soldier is present here!!");
        }

        if (soldier.getPlayerType() == playerType && soldier.canMoveTo(toBlock, blocks, fromBlock)) {
            moveSoldier(fromBlock, toBlock);
            if (doesKingHavingCheck(playerType)) {
                undoLastMove();
                throw new KingCheckException("King getting check");
            }
            return true;
        }
        throw new InValidMoveException("Invalid move ");
    }

    private boolean doesKingHavingCheck(Player.PlayerType playerType) {
        Block king = null;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (blocks[i][j].getSoldier() instanceof King && playerType == blocks[i][j].getSoldier().getPlayerType()) {
                    king = blocks[i][j];
                    break;
                }
            }
        }
        if (king == null) {
            throw new NoKingAvilableException("No avilaable king!!");
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (blocks[i][j].getSoldier() == null || blocks[i][j].getSoldier().getPlayerType() == playerType)
                    continue;
                if (blocks[i][j].getSoldier().canMoveTo(king, blocks, blocks[i][j])) {
                    return true;
                }
            }
        }
        return false;
    }

    private void moveSoldier(Block fromBlock, Block toBlock) {
        historyMoves.push(new HistoryTuple(fromBlock, toBlock, fromBlock.getSoldier(), toBlock.getSoldier()));
        Soldier soldier = fromBlock.getSoldier();
        toBlock.setSoldier(soldier);
        fromBlock.setSoldier(null);
    }

    public void printBoard() {
        System.out.println("---------------------------------------------");
        System.out.print("|   ");
        for (int i = 0; i < 8; i++) {
            System.out.print("| " + (i + 1) + "  ");
        }
        System.out.println(" |");
        System.out.println("---------------------------------------------");
        for (int i = 7; i >= 0; i--) {
            System.out.print("| " + (char) (i + 'A') + " ");
            for (int j = 0; j < 8; j++) {
                System.out.print("| ");
                if (blocks[i][j].getSoldier() == null) System.out.print("   ");
                else {
                    Player.PlayerType playerType = blocks[i][j].getSoldier().getPlayerType();
                    char C = 'P';
                    if (blocks[i][j].getSoldier() instanceof King) C = 'K';
                    else if (blocks[i][j].getSoldier() instanceof Queen) C = 'Q';
                    else if (blocks[i][j].getSoldier() instanceof Bishop) C = 'B';
                    else if (blocks[i][j].getSoldier() instanceof Elephant) C = 'E';
                    else if (blocks[i][j].getSoldier() instanceof Horse) C = 'H';
                    if (playerType == Player.PlayerType.WHITE) {
                        System.out.print("W" + C + " ");
                    } else {
                        System.out.print("B" + C + " ");
                    }
                }
            }
            System.out.println("|");
            System.out.println("---------------------------------------------");
        }
    }

    public void undoLastMove() {
        HistoryTuple lastMove = historyMoves.pop();
        // toBlock,  fromBlock
        Block toBlock = lastMove.getToBlock();
        Block fromBlock = lastMove.getFromBlock();
        blocks[toBlock.getRowCount()][toBlock.getColumnCount()].setSoldier(lastMove.getToSoldier());
        blocks[fromBlock.getRowCount()][fromBlock.getColumnCount()].setSoldier(lastMove.getFromSoldier());
    }
}
