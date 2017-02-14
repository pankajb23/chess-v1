package com.dejected;

import com.dejected.exception.InValidMoveException;
import com.dejected.player.Player;

/**
 * Created on 04/02/17 by dark magic.
 */
public class ChessBoard {
    private final Player playerWhite;
    private final Player playerBlack;

    public ChessBoard(Player playerWhite, Player playerBlack) {
        this.playerWhite = playerWhite;
        this.playerBlack = playerBlack;

        this.playerBlack.setOtherPlayer(this.playerWhite);
        this.playerWhite.setOtherPlayer(this.playerBlack);
    }

    public boolean moveWhitePlayer(Block fromBlock, Block toBlock) throws InValidMoveException {
        if (this.playerWhite.moveFromBlockTo(fromBlock, toBlock)) {
            this.playerBlack.killSoldierAtBlock(toBlock);
            return true;
        }
        return false;
    }

    public boolean moveBlackPlayer(Block fromBlock, Block toBlock) throws InValidMoveException {
        if (this.playerBlack.moveFromBlockTo(fromBlock, toBlock)) {
            this.playerWhite.killSoldierAtBlock(toBlock);
            return true;
        }
        return false;
    }

}
