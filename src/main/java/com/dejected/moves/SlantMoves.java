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
        if (toBlock.getSoldier() != null && toBlock.getSoldier().getPlayerType() == fromBlock.getSoldier().getPlayerType())
            return false;
        if (isOnSlant(toBlock, fromBlock)) {
            return canMoveOnSlant(toBlock, blocks, fromBlock);
        }
        return false;
    }


    private boolean canMoveOnSlant(Block toBlock, Block[][] blocks, Block fromBlock) {
        if ((toBlock.getColumnCount() - fromBlock.getColumnCount() != fromBlock.getRowCount() - toBlock.getRowCount())
                && (toBlock.getColumnCount() - fromBlock.getColumnCount() != toBlock.getRowCount() - fromBlock.getRowCount()))
            return false;

        int diffX = getDiffX(toBlock, fromBlock);
        int diffY = getDiffY(toBlock, fromBlock);
        for (int indX = diffX, indY = diffY; indX != (toBlock.getRowCount() - fromBlock.getRowCount()); indX += diffX, indY += diffY) {
            int row = fromBlock.getRowCount() + indX;
            int col = fromBlock.getColumnCount() + indY;
            Block bl = blocks[row][col];
            if (bl.getSoldier() != null) return false;
        }
        return true;
    }

    private int getDiffX(Block toBlock, Block fromBlock) {
        return toBlock.getRowCount() - fromBlock.getRowCount() < 0 ? -1 : 1;
    }

    private int getDiffY(Block toBlock, Block fromBlock) {
        return toBlock.getColumnCount() - fromBlock.getColumnCount() < 0 ? -1 : 1;
    }

    private boolean isOnSlant(Block toBlock, Block fromBlock) {
        int colDiff = Math.abs(toBlock.getColumnCount() - fromBlock.getColumnCount());
        int rowDiff = Math.abs(toBlock.getRowCount() - fromBlock.getRowCount());
        return (colDiff == rowDiff) && colDiff <= displacement && rowDiff <= displacement;
    }

}
