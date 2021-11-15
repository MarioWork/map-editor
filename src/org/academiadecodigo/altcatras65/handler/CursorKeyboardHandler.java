package org.academiadecodigo.altcatras65.handler;

import org.academiadecodigo.altcatras65.grid.SimpleGfxGrid;
import org.academiadecodigo.altcatras65.square.SquareHandler;
import org.academiadecodigo.altcatras65.square.Square;
import org.academiadecodigo.altcatras65.grid.GridDirectionType;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.util.LinkedList;

public class CursorKeyboardHandler implements KeyboardHandler {
    private Square playerSquare;
    private Square colorSquare;
    private LinkedList<Square> squares;
    private Keyboard keyboard;
    private Color currentColor;
    private SimpleGfxGrid mapGrid;

    public CursorKeyboardHandler(Square playerSquare, LinkedList<Square> squares, Square colorSquare, SimpleGfxGrid mapGrid) {
        this.playerSquare = playerSquare;
        this.squares = squares;
        this.currentColor = Color.BLACK;
        this.colorSquare = colorSquare;
        this.mapGrid = mapGrid;

        //adds the keys needed to the keyboard
        this.keyboard = new Keyboard(this);
        addKey(KeyboardEvent.KEY_UP);
        addKey(KeyboardEvent.KEY_DOWN);
        addKey(KeyboardEvent.KEY_LEFT);
        addKey(KeyboardEvent.KEY_RIGHT);
        addKey(KeyboardEvent.KEY_SPACE);
        addKey(KeyboardEvent.KEY_C);
        addKey(KeyboardEvent.KEY_1);
        addKey(KeyboardEvent.KEY_2);
        addKey(KeyboardEvent.KEY_3);
        addKey(KeyboardEvent.KEY_4);
        addKey(KeyboardEvent.KEY_5);

    }

    /**
     * Add a new key event to the keyboard
     *
     * @param key
     */
    private void addKey(int key) {
        KeyboardEvent event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        event.setKey(key);
        this.keyboard.addEventListener(event);

        event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        event.setKey(key);
        this.keyboard.addEventListener(event);
    }

    @Override
    public void keyPressed(KeyboardEvent e) {
        switch (e.getKey()) {
            case KeyboardEvent.KEY_UP:
                if (this.playerSquare.getPosition().getRow() > 0) {
                    this.playerSquare.move(GridDirectionType.UP);
                }
                break;
            case KeyboardEvent.KEY_DOWN:
                if (this.playerSquare.getPosition().getRow() < this.mapGrid.getRows() - 1) {
                    this.playerSquare.move(GridDirectionType.DOWN);
                }
                break;
            case KeyboardEvent.KEY_LEFT:
                if (this.playerSquare.getPosition().getCol() > 0) {
                    this.playerSquare.move(GridDirectionType.LEFT);
                }
                break;
            case KeyboardEvent.KEY_RIGHT:
                if (this.playerSquare.getPosition().getCol() < this.mapGrid.getCols() - 1) {
                    this.playerSquare.move(GridDirectionType.RIGHT);
                }
                
                break;
            case KeyboardEvent.KEY_SPACE:
                paint();
                break;
            case KeyboardEvent.KEY_C:
                SquareHandler.clearGrid(squares);
                break;
            case KeyboardEvent.KEY_1:
                changeColors(Color.BLACK);
                break;
            case KeyboardEvent.KEY_2:
                changeColors(Color.BLUE);
                break;
            case KeyboardEvent.KEY_3:
                changeColors(Color.GREEN);
                break;
            case KeyboardEvent.KEY_4:
                changeColors(Color.ORANGE);
                break;
            case KeyboardEvent.KEY_5:
                changeColors(Color.YELLOW);
                break;
        }
    }

    /**
     * Paint or clear a specific square
     */
    private void paint() {
        Square square = SquareHandler.check(this.playerSquare, squares);

        if (square.isPainted()) {
            square.clear();
        } else {
            this.playerSquare.paint(square, currentColor);
        }
    }

    private void changeColors(Color color) {
        this.currentColor = color;
        this.colorSquare.setColor(color);
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
