package com.dejected.block;

import com.dejected.moves.*;
import com.dejected.player.Player;
import com.dejected.soldiers.impl.*;

/**
 * Created on 18/02/17 by dark magic.
 */
public class BlockInit {
    public static final BlockInit INSTANCE = new BlockInit();
    private final Block[][] blocks = new Block[8][8];
    private Move pawnMoves = new PawnMoves();
    private Move SlantMoves = new SlantMoves(8);
    private Move StraightMove = new StraightMoves(8);

    private Move SlantMoves1Displacement = new SlantMoves(1);
    private Move StraightMove1Displacement = new StraightMoves(1);

    private Move horseMoves = new HorseMoves();

    private Move slantAndStraightMoves = new StraightAndSlantMoves(SlantMoves, StraightMove);
    private Move slantAndStraightMoves1DisplaceMent = new StraightAndSlantMoves(SlantMoves1Displacement, StraightMove1Displacement);

    private BlockInit() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                blocks[i][j] = new Block(i, j);
            }
        }

        init();
    }

    public Block[][] getBlocks() {
        return blocks;
    }

    private void init() {
        initPawn();
        initCamel();
        initElephant();
        initHorse();
        initQueen();
        initKing();
    }

    private void initKing() {
        blocks[0][3].setSoldier(new King(Player.PlayerType.WHITE, slantAndStraightMoves1DisplaceMent));
        blocks[7][3].setSoldier(new King(Player.PlayerType.BLACK, slantAndStraightMoves1DisplaceMent));
    }

    private void initQueen() {
        blocks[0][4].setSoldier(new Queen(Player.PlayerType.WHITE, slantAndStraightMoves));
        blocks[7][4].setSoldier(new Queen(Player.PlayerType.BLACK, slantAndStraightMoves));
    }

    private void initHorse() {
        blocks[0][1].setSoldier(new Horse(Player.PlayerType.WHITE, horseMoves));
        blocks[0][6].setSoldier(new Horse(Player.PlayerType.WHITE, horseMoves));
        blocks[7][1].setSoldier(new Horse(Player.PlayerType.BLACK, horseMoves));
        blocks[7][6].setSoldier(new Horse(Player.PlayerType.BLACK, horseMoves));
    }

    private void initElephant() {
        blocks[0][0].setSoldier(new Elephant(Player.PlayerType.WHITE, StraightMove));
        blocks[0][7].setSoldier(new Elephant(Player.PlayerType.WHITE, StraightMove));
        blocks[7][0].setSoldier(new Elephant(Player.PlayerType.BLACK, StraightMove));
        blocks[7][7].setSoldier(new Elephant(Player.PlayerType.BLACK, StraightMove));
    }

    private void initCamel() {
        blocks[0][2].setSoldier(new Bishop(Player.PlayerType.WHITE, SlantMoves));
        blocks[0][5].setSoldier(new Bishop(Player.PlayerType.WHITE, SlantMoves));
        blocks[7][2].setSoldier(new Bishop(Player.PlayerType.BLACK, SlantMoves));
        blocks[7][5].setSoldier(new Bishop(Player.PlayerType.BLACK, SlantMoves));
    }

    private void initPawn() {
        for (int j = 0; j < 8; j++) {
            blocks[1][j].setSoldier(new Pawn(Player.PlayerType.WHITE, pawnMoves));
            blocks[6][j].setSoldier(new Pawn(Player.PlayerType.BLACK, pawnMoves));
        }
    }
}
