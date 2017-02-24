package com.dejected.moves;

import com.dejected.block.Block;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created on 24/02/17 by dark magic.
 */
public class StraightMovesTest {
    StraightMoves straightMoves;
    Block[][] blocks = new Block[8][8];

    @Before
    public void setUp() throws Exception {
        straightMoves = new StraightMoves(8);
        initBlock();
    }

    private void initBlock() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                blocks[i][j] = new Block(i, j);
            }
        }
    }

    @Test
    public void test_vertical_move() {
        Block toBlock = new Block(1, 5);
        Block fromBlock = new Block(7, 5);
        assertTrue(straightMoves.canMoveToFrom(toBlock, blocks, fromBlock));
    }


    @Test
    public void test_horizantal_move() {
        Block toBlock = new Block(7, 5);
        Block fromBlock = new Block(7, 1);
        assertTrue(straightMoves.canMoveToFrom(toBlock, blocks, fromBlock));
    }

}