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
    }
}
