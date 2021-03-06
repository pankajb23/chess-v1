package com.dejected.soldiers.impl;

import com.dejected.block.Block;
import com.dejected.moves.Move;
import com.dejected.player.Player;
import com.dejected.soldiers.Soldier;

/**
 * Created on 04/02/17 by dark magic.
 */
public class King implements Soldier {
    private final Player.PlayerType playerType;
    private Move moves;

    public King(Player.PlayerType playerType, Move moves) {
        this.playerType = playerType;
        this.moves = moves;
    }

    @Override
    public boolean canMoveTo(Block toBlock, Block[][] blocks, Block fromBlock) {
        return moves.canMoveToFrom(toBlock, blocks, fromBlock);
    }

    @Override
    public Player.PlayerType getPlayerType() {
        return playerType;
    }
}
