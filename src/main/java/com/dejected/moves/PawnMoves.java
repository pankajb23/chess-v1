package com.dejected.moves;

import com.dejected.block.Block;
import com.dejected.player.Player;

/**
 * Created on 18/02/17 by dark magic.
 */
public class PawnMoves implements Move {

    @Override
    public boolean canMoveToFrom(Block toBlock, Block[][] blocks, Block fromBlock) {
        if (toBlock.getSoldier() != null && toBlock.getSoldier().getPlayerType() == fromBlock.getSoldier().getPlayerType())
            return false;

        return isOnlyForwardMove(toBlock, fromBlock) || (SlantToKill(toBlock, fromBlock));
    }

    private boolean SlantToKill(Block toBlock, Block fromBlock) {
        int multiplier = fromBlock.getSoldier().getPlayerType() == Player.PlayerType.WHITE ? 1 : -1;

        return ((toBlock.getColumnCount() == fromBlock.getColumnCount() + 1
                || toBlock.getColumnCount() == fromBlock.getColumnCount() - 1)
                && toBlock.getRowCount() == fromBlock.getRowCount() + multiplier
                && toBlock.getSoldier().getPlayerType() != fromBlock.getSoldier().getPlayerType());
    }

    private boolean isOnlyForwardMove(Block toBlock, Block fromBlock) {
        int multiplier = fromBlock.getSoldier().getPlayerType() == Player.PlayerType.WHITE ? 1 : -1;

        return (toBlock.getColumnCount() == fromBlock.getColumnCount()
                && toBlock.getRowCount() == fromBlock.getRowCount() + multiplier
                && toBlock.getSoldier() == null);
    }
}
