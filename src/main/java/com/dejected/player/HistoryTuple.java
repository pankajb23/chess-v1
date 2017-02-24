package com.dejected.player;

import com.dejected.block.Block;
import com.dejected.soldiers.Soldier;

/**
 * Created on 24/02/17 by dark magic.
 */
public class HistoryTuple {
    private Block toBlock;
    private Block fromBlock;
    private Soldier toSoldier;
    private Soldier fromSoldier;

    public Block getToBlock() {
        return toBlock;
    }

    public Block getFromBlock() {
        return fromBlock;
    }

    public Soldier getToSoldier() {
        return toSoldier;
    }

    public Soldier getFromSoldier() {
        return fromSoldier;
    }

    public HistoryTuple(Block toBlock, Block fromBlock, Soldier toSoldier, Soldier fromSoldier) {
        this.toBlock = toBlock;
        this.fromBlock = fromBlock;
        this.toSoldier = toSoldier;
        this.fromSoldier = fromSoldier;
    }
}
