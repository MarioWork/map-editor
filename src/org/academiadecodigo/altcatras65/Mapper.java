package org.academiadecodigo.altcatras65;

import org.academiadecodigo.altcatras65.grid.PositionChecker;
import org.academiadecodigo.altcatras65.grid.SimpleGfxGrid;
import org.academiadecodigo.altcatras65.grid.gridposition.GridPosition;
import org.academiadecodigo.altcatras65.handler.MapperKeyboardHandler;
import org.academiadecodigo.simplegraphics.graphics.Color;

import java.util.LinkedList;

public class Mapper {
    private SimpleGfxGrid mapGrid;
    private LinkedList<Square> squares;
    private Square squarePlayer;
    private PositionChecker positionChecker;

    public Mapper(int cols, int rows) {
        this.mapGrid = new SimpleGfxGrid(cols, rows);
        this.squares = new LinkedList<>();
        this.positionChecker = new PositionChecker(squares);
    }

    public void init() {
        this.mapGrid.init();
        createVisualGrid();
        this.squarePlayer = new Square(new GridPosition(this.mapGrid.getCols() / 2, this.mapGrid.getRows() / 2, this.mapGrid, true, Color.RED));
    }

    public void start() {
        new MapperKeyboardHandler(this.squarePlayer, this.squares, this.positionChecker);
    }

    private void createVisualGrid() {
        int col = 0;
        int row = 0;

        for (int i = 0; i < this.mapGrid.getRows(); i++) {
            for (int j = 0; j < this.mapGrid.getCols(); j++) {
                col = j;
                row = i;
                squares.add(new Square(this.mapGrid.makeGridPosition(col, row, false, Color.BLACK)));
            }
        }
    }
}
