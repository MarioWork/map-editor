package org.academiadecodigo.altcatras65;

import org.academiadecodigo.altcatras65.grid.SimpleGfxGrid;
import org.academiadecodigo.altcatras65.handler.CursorKeyboardHandler;
import org.academiadecodigo.altcatras65.square.Square;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;

import java.util.LinkedList;

public class Mapper {
    private SimpleGfxGrid mapGrid;
    private LinkedList<Square> squares;
    private Square squareCursor;
    private Square colorSquare;

    public Mapper(int cols, int rows) {
        this.mapGrid = new SimpleGfxGrid(cols, rows);
        this.squares = new LinkedList<>();
    }

    /**
     * Initialize the mapper
     */
    public void init() {
        this.mapGrid.init();
        createGrid();
        createCursor();
        createMenu();
    }

    private void createMenu() {
        this.colorSquare = new Square(this.mapGrid.makeSquareGridPosition(this.mapGrid.getCols() + 3, 1, true, Color.BLACK));
        this.mapGrid.makeGridPosition(this.mapGrid.getCols() + 1, 0, false, Color.BLACK, this.mapGrid.columnToX(6), this.mapGrid.rowToY(this.mapGrid.getRows())).draw();
        new Text(this.mapGrid.columnToX(this.mapGrid.getCols() + 2), this.mapGrid.rowToY(3), "WASD -> Move").draw();
        new Text(this.mapGrid.columnToX(this.mapGrid.getCols() + 2), this.mapGrid.rowToY(4), "SPACE -> Paint/Clear").draw();
        new Text(this.mapGrid.columnToX(this.mapGrid.getCols() + 2), this.mapGrid.rowToY(5), "1-6 -> Change Colors").draw();
        new Text(this.mapGrid.columnToX(this.mapGrid.getCols() + 2), this.mapGrid.rowToY(6), "C -> Clear Canvas").draw();

    }

    /**
     * Create the cursor square on screen
     */
    private void createCursor() {
        this.squareCursor = new Square(this.mapGrid.makeSquareGridPosition(this.mapGrid.getCols() / 2, this.mapGrid.getRows() / 2, true, Color.RED));
    }

    /**
     * start the mapper
     */
    public void start() {
        new CursorKeyboardHandler(this.squareCursor, this.squares, this.colorSquare, this.mapGrid);
    }


    /**
     * Create the  grid
     */
    private void createGrid() {
        int col = 0;
        int row = 0;

        for (int i = 0; i < this.mapGrid.getRows(); i++) {
            for (int j = 0; j < this.mapGrid.getCols(); j++) {
                col = j;
                row = i;
                squares.add(new Square(this.mapGrid.makeSquareGridPosition(col, row, false, Color.BLACK)));
            }
        }
    }
}
