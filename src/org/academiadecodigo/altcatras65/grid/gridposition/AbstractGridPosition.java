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



}
