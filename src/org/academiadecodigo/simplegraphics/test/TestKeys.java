package org.academiadecodigo.simplegraphics.test;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.awt.event.KeyEvent;
import java.util.Arrays;

/**
 * Created by tomasamaro on 18/10/16.
 */
public class TestKeys implements KeyboardHandler {

    private int timeLimit = 10000;
    int health = 20;
    private boolean[] keyPressed = new boolean[4];

    public void keyPressed(KeyboardEvent e) {


        switch (e.getKey()) {
            case KeyboardEvent.KEY_UP:
                keyPressed[0] = true;
                testMethod();
                break;
            case KeyboardEvent.KEY_DOWN:
                keyPressed[1] = true;
                testMethod();
                break;
            case KeyboardEvent.KEY_LEFT:
                keyPressed[2] = true;
                testMethod();
                break;
            case KeyboardEvent.KEY_RIGHT:
                keyPressed[3] = true;
                testMethod();
                break;
            default:
                System.out.println("Something Went Wrong");
        }
    }


    public void keyReleased(KeyboardEvent e) {
/*        switch (e.getKey()){
            case KeyboardEvent.KEY_UP:
                keyPressed[0] = false;
                break;
            default:
                System.out.println("Wrong key");
        }*/

    }


    public void testLogic() {


        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent eventUpPressed = new KeyboardEvent();
        eventUpPressed.setKey(KeyboardEvent.KEY_UP);
        eventUpPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventUpPressed);

        KeyboardEvent eventDownPressed = new KeyboardEvent();
        eventDownPressed.setKey(KeyboardEvent.KEY_DOWN);
        eventDownPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventDownPressed);

        KeyboardEvent eventLeftPressed = new KeyboardEvent();
        eventLeftPressed.setKey(KeyboardEvent.KEY_LEFT);
        eventLeftPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventLeftPressed);

        KeyboardEvent eventRightPressed = new KeyboardEvent();
        eventRightPressed.setKey(KeyboardEvent.KEY_RIGHT);
        eventRightPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventRightPressed);

       /* KeyboardEvent eventUpReleased = new KeyboardEvent();
        eventUpReleased.setKey(KeyboardEvent.KEY_UP);
        eventUpReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(eventUpReleased);*/

        System.out.println("Press UP");
    }

/*    public boolean anyKeyPressed() {
        for (int i = 0; i < keyPressed.length; i++)
            if (!keyPressed[i]) {
                return false;
            }
        return true;
    }*/


    public boolean correctkey(int keyPosition) {


        for (int i = 0; i < keyPressed.length; i++) {
            if (keyPosition != i && keyPressed[i] || keyPosition == i && !keyPressed[i]) {
                return false;
            }
        }
        return true;

    }


    public void testMethod() {


        if (correctkey(0)) {
            System.out.println("Well Done");
            keyPressed = new boolean[4];

        } else {
            System.out.println("Wrong key");
            keyPressed = new boolean[4];
            health--;
            System.out.println("My health is: " + health);
        }
        for (int i = 0; i < timeLimit; i++) {

            break;

        }
    }

    @Override
    public String toString() {
        return "TestKeys{" +
                "timeLimit=" + timeLimit +
                ", health=" + health +
                ", keyPressed=" + Arrays.toString(keyPressed) +
                '}';
    }
}

