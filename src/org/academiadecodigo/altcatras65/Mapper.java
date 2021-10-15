package org.academiadecodigo.altcatras65;

import org.academiadecodigo.altcatras65.grid.SimpleGfxGrid;

public class Mapper {
    private int delay;
    private SimpleGfxGrid mapGrid;

    public Mapper(int cols, int rows, int delay) {
        this.delay = delay;
        this.mapGrid = new SimpleGfxGrid(cols, rows);
    }

    public void init() {
        this.mapGrid.init();
        createVisualGrid();
    }


    private void createVisualGrid() {
        for (int i = mapGrid.PADDING/mapGrid.getCellSize(); i <=this.mapGrid.getRows(); i++) {
            for (int j = mapGrid.PADDING/mapGrid.getCellSize(); j <=this.mapGrid.getCols(); j++) {
                this.mapGrid.makeGridPosition(j, i);
            }
        }
    }
}
