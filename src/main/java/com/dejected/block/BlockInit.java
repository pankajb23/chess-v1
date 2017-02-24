package com.dejected.block;

import com.dejected.player.Player;
import com.dejected.soldiers.SoldierFactory;

/**
 * Created on 18/02/17 by dark magic.
 */

public class BlockInit {
    public static final BlockInit INSTANCE = new BlockInit();
    private final Block[][] blocks = new Block[8][8];

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
        blocks[0][3].setSoldier(SoldierFactory.getSoldier(SoldierFactory.SoldierType.KING, Player.PlayerType.WHITE));
        blocks[7][3].setSoldier(SoldierFactory.getSoldier(SoldierFactory.SoldierType.KING, Player.PlayerType.BLACK));
    }

    private void initQueen() {
        blocks[0][4].setSoldier(SoldierFactory.getSoldier(SoldierFactory.SoldierType.QUEEN, Player.PlayerType.WHITE));
        blocks[7][4].setSoldier(SoldierFactory.getSoldier(SoldierFactory.SoldierType.QUEEN, Player.PlayerType.BLACK));
    }

    private void initHorse() {
        blocks[0][1].setSoldier(SoldierFactory.getSoldier(SoldierFactory.SoldierType.HORSE, Player.PlayerType.WHITE));
        blocks[0][6].setSoldier(SoldierFactory.getSoldier(SoldierFactory.SoldierType.HORSE, Player.PlayerType.WHITE));
        blocks[7][1].setSoldier(SoldierFactory.getSoldier(SoldierFactory.SoldierType.HORSE, Player.PlayerType.BLACK));
        blocks[7][6].setSoldier(SoldierFactory.getSoldier(SoldierFactory.SoldierType.HORSE, Player.PlayerType.BLACK));
    }

    private void initElephant() {
        blocks[0][0].setSoldier(SoldierFactory.getSoldier(SoldierFactory.SoldierType.ELEPHANT, Player.PlayerType.WHITE));
        blocks[0][7].setSoldier(SoldierFactory.getSoldier(SoldierFactory.SoldierType.ELEPHANT, Player.PlayerType.WHITE));
        blocks[7][0].setSoldier(SoldierFactory.getSoldier(SoldierFactory.SoldierType.ELEPHANT, Player.PlayerType.BLACK));
        blocks[7][7].setSoldier(SoldierFactory.getSoldier(SoldierFactory.SoldierType.ELEPHANT, Player.PlayerType.BLACK));
    }

    private void initCamel() {
        blocks[0][2].setSoldier(SoldierFactory.getSoldier(SoldierFactory.SoldierType.CAMEL, Player.PlayerType.WHITE));
        blocks[0][5].setSoldier(SoldierFactory.getSoldier(SoldierFactory.SoldierType.CAMEL, Player.PlayerType.WHITE));
        blocks[7][2].setSoldier(SoldierFactory.getSoldier(SoldierFactory.SoldierType.CAMEL, Player.PlayerType.BLACK));
        blocks[7][5].setSoldier(SoldierFactory.getSoldier(SoldierFactory.SoldierType.CAMEL, Player.PlayerType.BLACK));
    }

    private void initPawn() {
        for (int j = 0; j < 8; j++) {
            blocks[1][j].setSoldier(SoldierFactory.getSoldier(SoldierFactory.SoldierType.PAWN, Player.PlayerType.WHITE));
            blocks[6][j].setSoldier(SoldierFactory.getSoldier(SoldierFactory.SoldierType.PAWN, Player.PlayerType.BLACK));
        }
    }
}
