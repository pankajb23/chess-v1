package com.dejected.moves;

import com.dejected.block.Block;

/**
 * Created on 18/02/17 by dark magic.
 */
public class StraightAndSlantMoves implements Move {
    private final Move straightMove;
    private final Move slantMove;

    public StraightAndSlantMoves(Move straightMove, Move slantMove) {
        this.straightMove = straightMove;
        this.slantMove = slantMove;
    }

    @Override
    public boolean canMoveToFrom(Block toBlock, Block[][] blocks, Block fromBlock) {
        return straightMove.canMoveToFrom(toBlock, blocks, fromBlock) || slantMove.canMoveToFrom(toBlock, blocks, fromBlock);
    }
}
