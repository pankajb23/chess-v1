package com.dejected.soldiers.impl;

import com.dejected.Block;
import com.dejected.player.PlayerType;
import com.dejected.soldiers.Soldier;

/**
 * Created on 04/02/17 by dark magic.
 */
public class Pawn implements Soldier {
    private Block currentBlock;
    private final PlayerType playerType;

    public Pawn(Block currentBlock, PlayerType playerType) {
        this.currentBlock = currentBlock;
        this.playerType = playerType;
    }

    @Override
    public boolean canMoveTo(Block block) {return false; }

    @Override
    public void moveToBlock(Block block) {
        this.currentBlock = block;
    }

    @Override
    public Block currentPosition() {
        return this.currentBlock;
    }
}
