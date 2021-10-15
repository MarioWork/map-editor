package org.academiadecodigo.altcatras65.grid;

import org.academiadecodigo.altcatras65.grid.gridposition.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class SimpleGfxGrid implements Grid {
    public static final int PADDING = 10;
    public final int cell_size = 30;
    private int cols;
    private int rows;
    private Rectangle recGrid;

    //Constructor
    public SimpleGfxGrid(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
        this.recGrid = new Rectangle(PADDING, PADDING, cols*cell_size, rows*cell_size);
    }

    //region Getters and Setters
    @Override
    public int getCellSize() {
        return this.cell_size;
    }

    @Override
    public int getCols() {
        return this.cols;
    }

    @Override
    public int getRows() {
        return this.rows;
    }
    //endregion

    //region methods
    @Override
    public void init() {
        this.recGrid.draw();
    }

    @Override
    public int rowToY(int row) {
        return row * cell_size;
    }

    @Override
    public int columnToX(int col) {
        return col * cell_size;
    }

    @Override
    public GridPosition makeGridPosition(int col, int row, boolean isFilled) {
        return new GridPosition(col,row,this,isFilled);
    }
    //endregion
}
