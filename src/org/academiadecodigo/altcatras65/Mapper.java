package org.academiadecodigo.altcatras65;

import org.academiadecodigo.altcatras65.grid.SimpleGfxGrid;
import org.academiadecodigo.altcatras65.grid.gridposition.GridPosition;
import org.academiadecodigo.altcatras65.handler.MapperKeyboardHandler;

import java.util.LinkedList;

public class Mapper {
    private SimpleGfxGrid mapGrid;
    private LinkedList<Square> Squares;
    private Square squarePlayer;

    public Mapper(int cols, int rows) {
        this.mapGrid = new SimpleGfxGrid(cols, rows);
        this.Squares = new LinkedList<>();
    }

    public void init() {
        this.mapGrid.init();
        createVisualGrid();
        squarePlayer = new Square(new GridPosition(this.mapGrid.getCols() / 2, this.mapGrid.getRows() / 2, this.mapGrid, true));
    }

    public void start() {
        new MapperKeyboardHandler(squarePlayer);
    }


    private void createVisualGrid() {
        int col = 0;
        int row = 0;

        for (int i = 0; i < this.mapGrid.getRows(); i++) {
            for (int j = 0; j < this.mapGrid.getCols(); j++) {
                col = j;
                row = i;
                Squares.add(new Square(this.mapGrid.makeGridPosition(col, row, false)));
            }
        }
    }
}
