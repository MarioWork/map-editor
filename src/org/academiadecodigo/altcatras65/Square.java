package org.academiadecodigo.altcatras65;

import org.academiadecodigo.altcatras65.grid.GridDirectionType;
import org.academiadecodigo.altcatras65.grid.gridposition.GridPosition;

public class Square {
    private GridPosition position;
    private static final int SPEED = 1;

    public Square(GridPosition position) {
        this.position = position;
    }

    public GridPosition getPosition() {
        return position;
    }

    public void move(GridDirectionType direction) {
        this.position.moveInDirection(direction, SPEED);
    }
}
