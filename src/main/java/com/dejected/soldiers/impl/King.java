package com.dejected.soldiers.impl;

import com.dejected.Block;
import com.dejected.player.PlayerType;
import com.dejected.soldiers.Soldier;

/**
 * Created on 04/02/17 by dark magic.
 */
public class King implements Soldier {
    private final PlayerType playerType;
    private Block currentBlock;

    private int[] positions = new int[]{-1, 0, 1};

    public King(Block currentBlock, PlayerType playerType) {
        this.playerType = playerType;
        this.currentBlock = currentBlock;
    }

    @Override
    public boolean canMoveTo(Block block) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (positions[i] == -1 && positions[j] == -1) continue;
                if ((block.getColumnCount() + positions[j] == this.currentBlock.getColumnCount()) && (block.getRowCount() + positions[i] == this.currentBlock.getRowCount()))
                    return true;
            }
        }
        return false;
    }

    @Override
    public void moveToBlock(Block block) {
        this.currentBlock = block;
    }

    @Override
    public Block currentPosition() {
        return this.currentBlock;
    }
}
