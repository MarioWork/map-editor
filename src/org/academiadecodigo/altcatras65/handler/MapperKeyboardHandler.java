package org.academiadecodigo.altcatras65.handler;

import org.academiadecodigo.altcatras65.grid.PositionChecker;
import org.academiadecodigo.altcatras65.Square;
import org.academiadecodigo.altcatras65.grid.GridDirectionType;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.util.LinkedList;

public class MapperKeyboardHandler implements KeyboardHandler {
    private Square playerSquare;
    private LinkedList<Square> squares;
    private Keyboard keyboard;
    private PositionChecker positionChecker;

    public MapperKeyboardHandler(Square playerSquare, LinkedList<Square> squares, PositionChecker positionChecker) {
        this.playerSquare = playerSquare;
        this.squares = squares;

        this.positionChecker = positionChecker;

        //adds the keys needed to the keyboard
        this.keyboard = new Keyboard(this);
        addKey(KeyboardEvent.KEY_UP);
        addKey(KeyboardEvent.KEY_DOWN);
        addKey(KeyboardEvent.KEY_LEFT);
        addKey(KeyboardEvent.KEY_RIGHT);
        addKey(KeyboardEvent.KEY_SPACE);
        addKey(KeyboardEvent.KEY_C);
    }

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
                this.playerSquare.move(GridDirectionType.UP);
                break;
            case KeyboardEvent.KEY_DOWN:
                this.playerSquare.move(GridDirectionType.DOWN);
                break;
            case KeyboardEvent.KEY_LEFT:
                this.playerSquare.move(GridDirectionType.LEFT);
                break;
            case KeyboardEvent.KEY_RIGHT:
                this.playerSquare.move(GridDirectionType.RIGHT);
                break;
            case KeyboardEvent.KEY_SPACE:
                this.playerSquare.paint(this.positionChecker.check(this.playerSquare));
                break;
            case KeyboardEvent.KEY_C:
                this.playerSquare.paint(this.positionChecker.check(this.playerSquare));
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
