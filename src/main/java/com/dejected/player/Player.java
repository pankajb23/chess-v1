package com.dejected.player;

import com.dejected.Block;
import com.dejected.BlockType;
import com.dejected.exception.InValidMoveException;
import com.dejected.exception.NoSoldierPresentException;
import com.dejected.soldiers.Soldier;
import com.dejected.soldiers.impl.*;
import sun.plugin.dom.exception.InvalidStateException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created on 04/02/17 by dark magic.
 */
public class Player {
    private final PlayerType playerType;
    private final String playerName;
    private List<Soldier> soldiers;
    private Player otherPlayer;

    public Player(PlayerType playerType, String playerName) {
        this.playerType = playerType;
        this.playerName = playerName;

        init();
    }

    private void init() {
        soldiers = new ArrayList<>(16);
        initPawn();
        initElephant();
        initCamel();
        initHorse();
        initQueen();
        initKing();

    }

    private void initPawn() {
        int rowCount = 7;
        int blockColorType = 1;
        if (playerType == PlayerType.WHITE) rowCount = 2;
        else blockColorType = 0;

        for (int i = 1; i <= 8; i++) {
            BlockType blockType = (i + blockColorType) % 2 == 0 ? BlockType.WHITE : BlockType.BLACK;
            soldiers.add(new Pawn(new Block(rowCount, i, blockType), playerType));
        }
    }

    private void initElephant() {
        int rowCount = 1;
        BlockType leftBlockType;
        BlockType rightBlockType;
        if (playerType == PlayerType.WHITE) {
            leftBlockType = BlockType.BLACK;
            rightBlockType = BlockType.WHITE;
        } else {
            rowCount = 8;
            leftBlockType = BlockType.WHITE;
            rightBlockType = BlockType.BLACK;
        }
        soldiers.add(new Elephant(new Block(rowCount, 1, leftBlockType), playerType));
        soldiers.add(new Elephant(new Block(rowCount, 8, rightBlockType), playerType));
    }

    private void initCamel() {
        int rowCount = 1;
        BlockType leftBlockType;
        BlockType rightBlockType;
        if (playerType == PlayerType.WHITE) {
            leftBlockType = BlockType.BLACK;
            rightBlockType = BlockType.WHITE;
        } else {
            rowCount = 8;
            leftBlockType = BlockType.WHITE;
            rightBlockType = BlockType.BLACK;
        }
        soldiers.add(new Elephant(new Block(rowCount, 3, leftBlockType), playerType));
        soldiers.add(new Elephant(new Block(rowCount, 5, rightBlockType), playerType));
    }

    private void initHorse() {
        int rowCount = 1;
        BlockType leftBlockType;
        BlockType rightBlockType;
        if (playerType == PlayerType.WHITE) {
            leftBlockType = BlockType.WHITE;
            rightBlockType = BlockType.BLACK;
        } else {
            rowCount = 8;
            leftBlockType = BlockType.BLACK;
            rightBlockType = BlockType.WHITE;
        }
        soldiers.add(new Camel(new Block(rowCount, 3, leftBlockType), playerType));
        soldiers.add(new Camel(new Block(rowCount, 5, rightBlockType), playerType));
    }

    private void initQueen() {
        int rowCount = 1;
        BlockType leftBlockType;
        if (playerType == PlayerType.WHITE) {
            leftBlockType = BlockType.WHITE;
        } else {
            rowCount = 8;
            leftBlockType = BlockType.BLACK;
        }
        soldiers.add(new Queen(new Block(rowCount, 4, leftBlockType), playerType));
    }

    private void initKing() {
        int rowCount = 1;
        BlockType leftBlockType;
        if (playerType == PlayerType.WHITE) {
            leftBlockType = BlockType.BLACK;
        } else {
            rowCount = 8;
            leftBlockType = BlockType.WHITE;
        }
        soldiers.add(new King(new Block(rowCount, 5, leftBlockType), playerType));
    }

    public boolean moveFromBlockTo(Block fromBlock, Block toBlock) {
        Optional<Soldier> soldierAtBlock = getSoldierAtBlock(fromBlock);
        if (!soldierAtBlock.isPresent()) {
            throw new NoSoldierPresentException("No soldier is present at column " + fromBlock.getColumnCount() + " row " + fromBlock.getRowCount());
        }

        if (soldierAtBlock.get().canMoveTo(toBlock)) {
            soldierAtBlock.get().moveToBlock(toBlock);
            return true;
        }
        throw new InValidMoveException("Soldier cann't move to the toBlock," + toBlock.toString());
    }

    private Optional<Soldier> getSoldierAtBlock(Block fromBlock) {

        for (int i = 0; i < soldiers.size(); i++) {
            if (isSame(soldiers.get(i).currentPosition(), fromBlock)) {
                return Optional.of(soldiers.get(i));
            }
        }
        return Optional.empty();
    }

    private boolean isSame(Block block, Block fromBlock) {
        return block.getColumnCount() == fromBlock.getColumnCount() && block.getRowCount() == fromBlock.getRowCount();
    }

    public void killSoldierAtBlock(Block toBlock) {
        Optional<Soldier> soldier = getSoldierAtBlock(toBlock);
        if (!soldier.isPresent()) {
            throw new InvalidStateException("Current state is invalid");
        }
        soldiers.remove(soldier.get());
    }

    public void setOtherPlayer(Player otherPlayer) {
        this.otherPlayer = otherPlayer;
    }
}
