package com.dejected.soldiers;

import com.dejected.Block;

/**
 * Created on 04/02/17 by dark magic.
 */
public interface Soldier {
    boolean canMoveTo(Block block);

    void moveToBlock(Block block);

    Block currentPosition();
}
