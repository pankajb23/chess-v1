package com.dejected;

import com.dejected.block.Block;
import com.dejected.block.BlockInit;
import com.dejected.exception.NoKingAvilableException;
import com.dejected.exception.NoSoldierPresentException;
import com.dejected.player.Player;
import com.dejected.soldiers.Soldier;
import com.dejected.soldiers.impl.King;

/**
 * Created on 04/02/17 by dark magic.
 */
public class ChessBoard {
    private final Player playerWhite;
    private final Player playerBlack;
    private final Block[][] blocks;

    public ChessBoard(Player playerWhite, Player playerBlack) {
        this.playerWhite = playerWhite;
        this.playerBlack = playerBlack;

        blocks = BlockInit.INSTANCE.getBlocks();
    }

    public void moveWhitePlayer(Block fromBlock, Block toBlock) {
        if (moveSoldier(fromBlock, toBlock, Player.PlayerType.WHITE)) {
            this.playerWhite.playerMove(fromBlock, toBlock);
        }
    }

    public void moveBlackPlayer(Block fromBlock, Block toBlock) {
        if (moveSoldier(fromBlock, toBlock, Player.PlayerType.BLACK)) {
            this.playerBlack.playerMove(fromBlock, toBlock);
        }
    }

    public boolean moveSoldier(Block fromBlock, Block toBlock, Player.PlayerType playerType) {
        Soldier soldier = fromBlock.getSoldier();
        if (soldier == null) {
            throw new NoSoldierPresentException("No soldier is present here!!");
        }

        if (soldier.getPlayerType() == playerType && soldier.canMoveTo(toBlock, blocks, fromBlock)) {
            moveSoldier(fromBlock, toBlock);
            if (doesKingHavingCheck(playerType)) {
                moveSoldier(toBlock, fromBlock);
                return false;
            }
            return true;
        }
        return false;
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
                if (blocks[i][j].getSoldier().getPlayerType() == playerType) continue;
                if (blocks[i][j].getSoldier().canMoveTo(king, blocks, blocks[i][j])) {
                    return true;
                }
            }
        }
        return false;
    }

    private void moveSoldier(Block fromBlock, Block toBlock) {
        Soldier soldier = fromBlock.getSoldier();
        toBlock.setSoldier(soldier);
        fromBlock.setSoldier(null);
    }
}
