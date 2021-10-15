package org.academiadecodigo.altcatras65.grid;

import org.academiadecodigo.altcatras65.Square;

import java.util.LinkedList;

public class PositionChecker {
    private LinkedList<Square> squares;

    public PositionChecker(LinkedList<Square> squares) {
        this.squares = squares;
    }

    public Square check(Square paramSquare) {
        for (Square square : squares) {
            if (paramSquare.getPosition().equals(square.getPosition())) {
                return square;
            }
        }
        return null;
    }
}
