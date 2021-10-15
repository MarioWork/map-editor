package org.academiadecodigo.altcatras65.grid.gridposition;

import org.academiadecodigo.altcatras65.grid.GridDirectionType;
import org.academiadecodigo.altcatras65.grid.SimpleGfxGrid;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class GridPosition extends AbstractGridPosition {

    private SimpleGfxGrid mapGrid;
    private Rectangle recPosition;

    public GridPosition(int col, int row, SimpleGfxGrid mapGrid, boolean isFilled, Color color) {
        super(col, row, mapGrid);
        this.mapGrid = mapGrid;
        this.recPosition = new Rectangle(mapGrid.columnToX(col), mapGrid.rowToY(row), mapGrid.getCellSize(), mapGrid.getCellSize());
        this.recPosition.setColor(color);

        if (isFilled) {
            this.fill();
            return;
        }

        this.draw();
    }

    public void draw() {
        this.recPosition.draw();
    }

    public void fill() {
        this.recPosition.fill();
    }

    public void moveInDirection(GridDirectionType direction, int distance) {

        switch (direction) {
            case UP:
                this.recPosition.translate(0, -this.mapGrid.rowToY(distance));
                super.moveUp(distance);
                break;
            case DOWN:
                this.recPosition.translate(0, +this.mapGrid.rowToY(distance));
                super.moveDown(distance);
                break;
            case LEFT:
                this.recPosition.translate(-this.mapGrid.columnToX(distance), 0);
                super.moveLeft(distance);
                break;
            case RIGHT:
                this.recPosition.translate(+this.mapGrid.columnToX(distance), 0);
                super.moveRight(distance);
                break;
        }
    }

}
