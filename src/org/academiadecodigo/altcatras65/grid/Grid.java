package org.academiadecodigo.altcatras65.grid;

public interface Grid {

    void init();

    /**
     * Converts a row to pixels (Y)
     * @param row
     */
    int rowToY(int row);


    /**
     * Converts a col to pixels (x)
     * @param col
     */
    int columnToX(int col);

    /**
     * Returns the cell size property
     * @return
     */
    int getCellSize();


    /**
     * Creates a new position in the grid at a specific col and row
     * @param col
     * @param row
     */
    void makeGridPosition(int col, int row);
}
