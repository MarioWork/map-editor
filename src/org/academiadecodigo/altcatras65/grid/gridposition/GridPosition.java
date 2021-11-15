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
        this.recPosition = new Rectangle(mapGrid.columnToX(col) + this.mapGrid.PADDING, mapGrid.rowToY(row) + this.mapGrid.PADDING, mapGrid.getCellSize(), mapGrid.getCellSize());
        this.recPosition.setColor(color);

        if (isFilled) {
            this.fill();
            return;
        }

        this.draw();
    }

    public GridPosition(int col, int row, SimpleGfxGrid mapGrid, boolean isFilled, Color color, int width, int height) {
        super(col, row, mapGrid);
        this.mapGrid = mapGrid;
        this.recPosition = new Rectangle(mapGrid.columnToX(col) + this.mapGrid.PADDING, mapGrid.rowToY(row) + this.mapGrid.PADDING, width, height);
        this.recPosition.setColor(color);

        if (isFilled) {
            this.fill();
            return;
        }

        this.draw();
    }


    /**
     * Draw only the rectangle border
     */
    public void draw() {
        this.recPosition.draw();
    }

    /**
     * Fill the rectangle
     */
    public void fill() {
        this.recPosition.fill();
    }

    /**
     * Change the color of the square
     * @param color
     */
    public void setColor(Color color) {
        recPosition.setColor(color);
    }


    /**
     * Move the square in the direction received by the distance received
     * @param direction
     * @param distance
     */
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
