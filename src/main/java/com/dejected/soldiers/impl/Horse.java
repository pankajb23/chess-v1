package com.dejected.soldiers.impl;

import com.dejected.Block;
import com.dejected.player.PlayerType;
import com.dejected.soldiers.Soldier;

/**
 * Created on 04/02/17 by dark magic.
 */
public class Horse implements Soldier {
    private final PlayerType playerType;
    private Block currentBlock;

    public Horse(PlayerType playerType, Block currentBlock) {
        this.playerType = playerType;
        this.currentBlock = currentBlock;
    }

    @Override
    public boolean canMoveTo(Block block) {
        return false;
    }

    @Override
    public void moveToBlock(Block block) {

    }

    @Override
    public Block currentPosition() {
        return this.currentBlock;
    }
}
