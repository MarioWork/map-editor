package org.academiadecodigo.altcatras65.square;

import org.academiadecodigo.altcatras65.square.Square;
import org.academiadecodigo.simplegraphics.graphics.Color;

import java.util.LinkedList;

public class SquareHandler {

    /**
     * Clear all squares of the grid
     * @param squares
     */
    public static void clearGrid(LinkedList<Square> squares) {
        for (Square square : squares) {
            square.setPainted(false);
            square.setColor(Color.BLACK);
            square.getPosition().setColor(square.getColor());
            square.getPosition().draw();
        }
    }

    /**
     * Check which square is in the same position of the square received by parameter
     * @param paramSquare
     * @param squares
     * @return
     */
    public static Square check(Square paramSquare, LinkedList<Square> squares) {
        for (Square square : squares) {
            if (paramSquare.getPosition().equals(square.getPosition())) {
                return square;
            }
        }
        return null;
    }
}
