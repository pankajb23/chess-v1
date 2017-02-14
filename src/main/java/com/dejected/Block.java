package com.dejected;

/**
 * Created on 04/02/17 by dark magic.
 */
public class Block {
    private final int rowCount;
    private final int columnCount;

    public Block(int rowCount, int columnCount) {
        assert rowCount > 0 && rowCount < 9;
        assert columnCount > 0 && columnCount < 9;

        this.rowCount = rowCount;
        this.columnCount = columnCount;
    }

    public int getRowCount() {
        return rowCount;
    }

    public int getColumnCount() {
        return columnCount;
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
}
