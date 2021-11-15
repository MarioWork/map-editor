package org.academiadecodigo.altcatras65.grid;

import org.academiadecodigo.altcatras65.grid.gridposition.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Color;

public interface Grid {

    /**
     * Returns the cell size property
     *
     * @return
     */
    int getCellSize();

    /**
     * Returns the number of cols the grid has
     *
     * @return
     */
    int getCols();

    /**
     * Returns the number of rows the grid has
     *
     * @return
     */
    int getRows();

    /**
     * Initializes the grid
     */
    void init();

    /**
     * Converts a row to pixels (Y)
     *
     * @param row
     */
    int rowToY(int row);


    /**
     * Converts a col to pixels (x)
     *
     * @param col
     */
    int columnToX(int col);

    /**
     * Creates a new position in the grid at a specific col and row
     *
     * @param col
     * @param row
     * @param color
     */
    GridPosition makeSquareGridPosition(int col, int row, boolean isFilled, Color color);

    /**
     * Create a new position int the grid at a specific col and row and a specific width and height
     * @param col
     * @param row
     * @param isFilled
     * @param color
     * @param width
     * @param height
     * @return
     */
    GridPosition makeGridPosition(int col, int row, boolean isFilled, Color color, int width, int height);


}
