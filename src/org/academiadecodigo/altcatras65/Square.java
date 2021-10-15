package org.academiadecodigo.altcatras65;

import org.academiadecodigo.altcatras65.grid.GridDirectionType;
import org.academiadecodigo.altcatras65.grid.gridposition.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Color;

public class Square {
    private GridPosition position;
    private static final int SPEED = 1;
    private boolean isPainted;

    public Square(GridPosition position) {
        this.position = position;
    }

    public GridPosition getPosition() {
        return position;
    }

    public void setPainted(boolean painted) {
        isPainted = painted;
    }

    public void move(GridDirectionType direction) {
        this.position.moveInDirection(direction, SPEED);
    }

    public void paint(Square square){
        square.setPainted(true);
        square.getPosition().fill();
    }
}
