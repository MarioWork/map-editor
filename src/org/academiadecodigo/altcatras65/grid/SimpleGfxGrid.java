package org.academiadecodigo.altcatras65.grid;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class SimpleGfxGrid implements Grid {
    private static final int PADDING = 10;
    public final int cell_size = 10;
    private int cols;
    private int rows;
    private Rectangle recGrid;


    public SimpleGfxGrid(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
        this.recGrid = new Rectangle(PADDING, PADDING, columnToX(cols), rowToY(rows));
    }

    @Override
    public int getCellSize() {
        return this.cell_size;
    }


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
    public void makeGridPosition(int col, int row) {

    }
}
