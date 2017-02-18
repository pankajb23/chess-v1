package com.dejected.player;

import com.dejected.block.Block;

import java.util.Stack;

/**
 * Created on 04/02/17 by dark magic.
 */
public class Player {
    private final PlayerType playerType;
    private final String playerName;
    private Stack<Pair<Block, Block>> moves;
    private Player otherPlayer;

    public Player(PlayerType playerType, String playerName) {
        this.playerType = playerType;
        this.playerName = playerName;

        moves = new Stack<>();
    }

    public void playerMove(Block fromBlock, Block toBlock) {
        moves.add(new Pair<>(fromBlock, toBlock));
    }

    public Pair<Block, Block> getLastMoves() {
        return moves.peek();
    }

    public Pair<Block, Block> popLastMoves() {
        return moves.pop();
    }

    public enum PlayerType{
        WHITE,
        BLACK
    }
}
