package com.dejected.moves;

import com.dejected.block.Block;

/**
 * Created on 18/02/17 by dark magic.
 */
public class HorseMoves implements Move {
    @Override
    public boolean canMoveToFrom(Block toblock, Block[][] blocks, Block fromBlock) {
        if (toblock.getSoldier() != null && toblock.getSoldier().getPlayerType() == fromBlock.getSoldier().getPlayerType())
            return false;

        int rowDiff = Math.abs(toblock.getRowCount() - fromBlock.getRowCount());
        int colDiff = Math.abs(toblock.getColumnCount() - fromBlock.getColumnCount());
        if ((rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2)) return true;
        return false;
    }
}
