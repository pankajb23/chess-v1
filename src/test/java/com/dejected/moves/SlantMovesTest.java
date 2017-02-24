package com.dejected.moves;

import com.dejected.block.Block;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


/**
 * Created on 24/02/17 by dark magic.
 */
public class SlantMovesTest {
    SlantMoves slantMoves;
    Block[][] blocks = new Block[8][8];

    @Before
    public void setUp() throws Exception {
        slantMoves = new SlantMoves(8);
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
    public void should_move_left_slantfor_5Blocks_forQueen() throws Exception {

        Block toBlock = new Block(5, 1);
        Block fromBlock = new Block(1, 5);
        assertTrue(slantMoves.canMoveToFrom(toBlock, blocks, fromBlock));
    }

    @Test
    public void should_move_right_slantfor_5Blocks_forQueen() throws Exception {

        Block toBlock = new Block(2, 2);
        Block fromBlock = new Block(5, 5);
        assertTrue(slantMoves.canMoveToFrom(toBlock, blocks, fromBlock));
    }


    @Test
    public void should_move_right_slant_bottm_for_5Blocks_forQueen() throws Exception {

        Block toBlock = new Block(5, 5);
        Block fromBlock = new Block(2, 2);
        assertTrue(slantMoves.canMoveToFrom(toBlock, blocks, fromBlock));
    }

}