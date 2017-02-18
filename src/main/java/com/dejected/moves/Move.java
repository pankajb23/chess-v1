package com.dejected.moves;

import com.dejected.block.Block;

/**
 * Created on 18/02/17 by dark magic.
 */
public interface Move {

    boolean canMoveToFrom(Block toBlock, Block[][] blocks, Block fromBlock);
}
