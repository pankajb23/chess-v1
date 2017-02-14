package com.dejected.moves;

import com.dejected.Block;
import com.dejected.player.PlayerType;

/**
 * Created on 05/02/17 by dark magic.
 */
public class MovesUtil {
    public static MovesUtil INSTANCE = new MovesUtil();

    public boolean canMoveXYPlanesfromBtoB(Block fromBlock, Block toBlock) {
        if(!(fromBlock.getRowCount()-toBlock.getRowCount()==0 || fromBlock.getColumnCount()-toBlock.getColumnCount()==0)){
            return false;
        }

    }


}
