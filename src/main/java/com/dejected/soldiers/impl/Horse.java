package com.dejected.soldiers.impl;

import com.dejected.block.Block;
import com.dejected.moves.Move;
import com.dejected.player.Player;
import com.dejected.soldiers.Soldier;

/**
 * Created on 04/02/17 by dark magic.
 */
public class Horse implements Soldier {
    private final Player.PlayerType playerType;
    private final Move move;

    public Horse(Player.PlayerType playerType, Move move) {
        this.playerType = playerType;
        this.move = move;
    }

    @Override
    public boolean canMoveTo(Block block, Block[][] blocks, Block fromBlock) {
        return move.canMoveToFrom(block, blocks, fromBlock);
    }
    @Override
    public Player.PlayerType getPlayerType() {
        return playerType;
    }
}
