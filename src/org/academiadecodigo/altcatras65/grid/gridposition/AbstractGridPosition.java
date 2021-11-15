package org.academiadecodigo.altcatras65.grid.gridposition;

import org.academiadecodigo.altcatras65.grid.SimpleGfxGrid;

public abstract class AbstractGridPosition {
    private int col;
    private int row;
    private SimpleGfxGrid mapGrid;

    public AbstractGridPosition(int col, int row, SimpleGfxGrid mapGrid) {
        this.col = col;
        this.row = row;
        this.mapGrid = mapGrid;
    }

    //region Getters and Setters
    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }
    //endregion

    //region Methods
    /**
     * Decrease the rows by the distance
     * @param distance
     */
    public void moveUp(int distance) {
        this.row -= distance;
    }

    /**
     * Increase the rows by the distance
     * @param distance
     */
    public void moveDown(int distance) {
        this.row += distance;
    }

    /**
     * Decrease the col by the distance
     * @param distance
     */
    public void moveLeft(int distance) {
        this.col -= distance;
    }

    /**
     *
     * @param distance
     */
    public void moveRight(int distance) {
        this.col += distance;
    }
    //endregion


    @Override
    public boolean equals(Object obj) {
        GridPosition gridPosition = null;
        if (obj instanceof GridPosition) {
            gridPosition = ((GridPosition) obj);
        }

        return this.col == gridPosition.getCol() && this.row == gridPosition.getRow();
    }
}
