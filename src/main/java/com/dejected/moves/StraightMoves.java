package com.dejected.moves;

import com.dejected.block.Block;

/**
 * Created on 18/02/17 by dark magic.
 */
public class StraightMoves implements Move {
    private final int displaceMent;

    public StraightMoves(int displaceMent) {
        this.displaceMent = displaceMent;
    }

    @Override
    public boolean canMoveToFrom(Block toBlock, Block[][] blocks, Block fromBlock) {
        if (toBlock.getSoldier().getPlayerType() == fromBlock.getSoldier().getPlayerType()) return false;

        if (isOnHorizontalBlock(toBlock, fromBlock) || isOnVerticalBlock(toBlock, fromBlock)) {
            return canMoveOnVertical(toBlock, blocks, fromBlock) || canMoveHorizontal(toBlock, blocks, fromBlock);
        }
        return false;

    }

    private boolean canMoveOnVertical(Block toBlock, Block[][] blocks, Block fromBlock) {
        if (!isOnVerticalBlock(toBlock, fromBlock)) return false;

        int multiplier = toBlock.getColumnCount() > fromBlock.getColumnCount() ? 1 : -1;
        for (int col = fromBlock.getColumnCount() + multiplier; col != toBlock.getColumnCount(); col += multiplier) {
            Block bl = blocks[fromBlock.getRowCount()][col];
            if (bl.getSoldier() != null) return false;
        }
        return true;
    }

    private boolean canMoveHorizontal(Block toBlock, Block[][] blocks, Block fromBlock) {
        if (!isOnHorizontalBlock(toBlock, fromBlock)) return false;

        int multiplier = toBlock.getRowCount() > fromBlock.getRowCount() ? 1 : -1;
        for (int row = fromBlock.getRowCount() + multiplier; row != toBlock.getRowCount(); row += multiplier) {
            Block bl = blocks[row][fromBlock.getColumnCount()];
            if (bl.getSoldier() != null) return false;
        }
        return true;
    }

    private boolean isOnVerticalBlock(Block toBlock, Block fromBlock) {
        return (toBlock.getRowCount() != fromBlock.getRowCount()) && toBlock.getColumnCount() == fromBlock.getColumnCount();
    }

    private boolean isOnHorizontalBlock(Block toBlock, Block fromBlock) {
        return (toBlock.getRowCount() == fromBlock.getRowCount()) && toBlock.getColumnCount() != fromBlock.getColumnCount();
    }

}
