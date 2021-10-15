package org.academiadecodigo.altcatras65.handler;

import org.academiadecodigo.altcatras65.Square;
import org.academiadecodigo.altcatras65.grid.GridDirectionType;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class MapperKeyboardHandler implements KeyboardHandler {
    private Square square;
    private Keyboard keyboard;

    public MapperKeyboardHandler(Square square) {
        this.square = square;

        //adds the keys needed to the keyboard
        this.keyboard = new Keyboard(this);
        addKey(KeyboardEvent.KEY_UP);
        addKey(KeyboardEvent.KEY_DOWN);
        addKey(KeyboardEvent.KEY_LEFT);
        addKey(KeyboardEvent.KEY_RIGHT);
        addKey(KeyboardEvent.KEY_SPACE);
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
                this.square.move(GridDirectionType.UP);
                break;
            case KeyboardEvent.KEY_DOWN:
                this.square.move(GridDirectionType.DOWN);
                break;
            case KeyboardEvent.KEY_LEFT:
                this.square.move(GridDirectionType.LEFT);
                break;
            case KeyboardEvent.KEY_RIGHT:
                this.square.move(GridDirectionType.RIGHT);
                break;
            case KeyboardEvent.KEY_SPACE:

                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
