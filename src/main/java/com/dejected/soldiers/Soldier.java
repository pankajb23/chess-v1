package com.dejected.soldiers;

import com.dejected.block.Block;
import com.dejected.player.Player;

/**
 * Created on 04/02/17 by dark magic.
 */
public interface Soldier {
    boolean canMoveTo(Block toBlock, Block[][] blocks, Block fromBlock);

    Player.PlayerType getPlayerType();
}
