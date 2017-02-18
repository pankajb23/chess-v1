package com.dejected.block;

import com.dejected.soldiers.Soldier;

/**
 * Created on 04/02/17 by dark magic.
 */
public class Block {
    private final int rowCount;
    private final int columnCount;
    private final BlockType blockType;
    private Soldier soldier;

    public Block(int rowCount, int columnCount) {
        assert rowCount >= 0 && rowCount < 8;
        assert columnCount >= 0 && columnCount < 8;

        this.rowCount = rowCount;
        this.columnCount = columnCount;

        this.blockType = (this.rowCount + this.columnCount) % 2 == 1 ? BlockType.WHITE : BlockType.WHITE;
    }

    public int getRowCount() {
        return rowCount;
    }

    public int getColumnCount() {
        return columnCount;
    }

    public BlockType getBlockType() {
        return blockType;
    }

    @Override
    public String toString() {
        return "Block{" +
                "rowCount=" + rowCount +
                ", columnCount=" + columnCount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Block block = (Block) o;

        if (rowCount != block.rowCount) return false;
        return columnCount == block.columnCount;

    }

    @Override
    public int hashCode() {
        int result = rowCount;
        result = 31 * result + columnCount;
        return result;
    }

    public Soldier getSoldier() {
        return soldier;
    }

    public void setSoldier(Soldier soldier) {
        this.soldier = soldier;
    }

    public enum BlockType {
        WHITE,
        BLACK
    }
}
