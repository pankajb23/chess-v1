package com.dejected.soldiers.impl;

import com.dejected.Block;
import com.dejected.player.PlayerType;
import com.dejected.soldiers.Soldier;

/**
 * Created on 04/02/17 by dark magic.
 */
public class Elephant implements Soldier {
    private final PlayerType playerType;
    private Block currentBlock;

    public Elephant(Block currentBlock, PlayerType playerType) {
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
