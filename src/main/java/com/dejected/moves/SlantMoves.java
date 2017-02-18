package com.dejected.moves;

import com.dejected.block.Block;

/**
 * Created on 18/02/17 by dark magic.
 */
public class SlantMoves implements Move {
    private final int displacement;

    public SlantMoves(int displacement) {
        this.displacement = displacement;
    }

    @Override
    public boolean canMoveToFrom(Block toBlock, Block[][] blocks, Block fromBlock) {
        if (toBlock.getSoldier().getPlayerType() == fromBlock.getSoldier().getPlayerType()) return false;
        if (isOnSlant(toBlock, fromBlock)) {
            return canMoveOnLeftSlant(toBlock, blocks, fromBlock) || canMoveOnRightSlant(toBlock, blocks, fromBlock);
        }
        return false;
    }

    private boolean canMoveOnRightSlant(Block block, Block[][] blocks, Block fromBlock) {
        if (!(block.getColumnCount() - fromBlock.getColumnCount() == block.getRowCount() - fromBlock.getRowCount()))
            return false;

        int multiplier = block.getColumnCount() > fromBlock.getColumnCount() ? 1 : -1;
        for (int index = multiplier; index != (block.getColumnCount() - fromBlock.getColumnCount()); index += multiplier) {
            int row = fromBlock.getRowCount() + index;
            int col = fromBlock.getColumnCount() + index;
            Block bl = blocks[row][col];
            if (bl.getSoldier() != null) return false;
        }
        return true;
    }

    private boolean canMoveOnLeftSlant(Block block, Block[][] blocks, Block fromBlock) {
        if ((block.getColumnCount() - fromBlock.getColumnCount() == fromBlock.getRowCount() - block.getRowCount()))
            return false;

        int multiplier = block.getRowCount() > fromBlock.getRowCount() ? 1 : -1;
        for (int index = multiplier; index != (block.getRowCount() - fromBlock.getRowCount()); index += multiplier) {
            int row = fromBlock.getRowCount() + index;
            int col = fromBlock.getColumnCount() + index * multiplier;
            Block bl = blocks[row][col];
            if (bl.getSoldier() != null) return false;
        }
        return true;
    }

    private boolean isOnSlant(Block toBlock, Block fromBlock) {
        int colDiff = Math.abs(toBlock.getColumnCount() - fromBlock.getColumnCount());
        int rowDiff = Math.abs(toBlock.getRowCount() - fromBlock.getRowCount());
        return (colDiff == rowDiff) && colDiff <= displacement && rowDiff <= displacement;
    }

}
