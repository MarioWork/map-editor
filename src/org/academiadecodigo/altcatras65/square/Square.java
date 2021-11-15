package org.academiadecodigo.altcatras65.square;

import org.academiadecodigo.altcatras65.grid.GridDirectionType;
import org.academiadecodigo.altcatras65.grid.SimpleGfxGrid;
import org.academiadecodigo.altcatras65.grid.gridposition.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Color;

public class Square {
    private GridPosition position;
    private static final int SPEED = 1;
    private boolean isPainted;
    private Color color;

    public Square(GridPosition position) {
        this.position = position;
    }

    //region Getters and Setters
    public GridPosition getPosition() {
        return position;
    }

    public Color getColor() {
        return color;
    }

    public boolean isPainted() {
        return isPainted;
    }

    public void setPainted(boolean painted) {
        isPainted = painted;
    }
    //endregion

    //region Methods
    public void move(GridDirectionType direction) {
            this.position.moveInDirection(direction, SPEED);
    }

    public void paint(Square square, Color color) {
        square.setPainted(true);
        this.color = color;
        square.getPosition().setColor(color);
        square.getPosition().fill();
    }

    public void setColor(Color color) {
        this.color = color;
        this.position.setColor(color);
    }

    public void clear() {
        this.isPainted = false;
        this.color = Color.BLACK;
        this.position.setColor(color);
        this.position.draw();
    }

    //endregion
}
