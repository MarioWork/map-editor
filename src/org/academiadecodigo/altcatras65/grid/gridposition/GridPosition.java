package org.academiadecodigo.altcatras65.grid.gridposition;

import org.academiadecodigo.altcatras65.grid.SimpleGfxGrid;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class GridPosition extends AbstractGridPosition{

    private SimpleGfxGrid mapGrid;
    private Rectangle recPosition;

    public GridPosition(int col, int row, SimpleGfxGrid mapGrid) {
        super(col, row, mapGrid);
        this.recPosition = new Rectangle(mapGrid.columnToX(col),mapGrid.rowToY(row), mapGrid.getCellSize(),mapGrid.getCellSize());
        this.show();
    }

    public void show(){
        this.recPosition.draw();
    }


}
