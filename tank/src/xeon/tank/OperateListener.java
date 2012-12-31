package xeon.tank;

import xeon.tank.abs.EventHandler;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * User: xeon
 * Date: 12/31/12
 * Time: 2:10 PM
 */
public class OperateListener extends KeyAdapter {

    private EventHandler handler;

    public OperateListener(EventHandler handler){
        super();
        this.handler = handler;
    }

    /** Handle the key typed event from the text field. */
    public void keyTyped(KeyEvent e) {
        displayInfo(e, "KEY TYPED: ");
    }

    /** Handle the key-pressed event from the text field. */
    public void keyPressed(KeyEvent e) {
        displayInfo(e, "KEY PRESSED: ");

        switch (e.getKeyCode()) {
            case 37 :
                leftKeyPressed(e);
                break;
            case 38 :
                upKeyPressed(e);
                break;
            case 39 :
                rightKeyPressed(e);
                break;
            case 40 :
                downKeyPressed(e);
                break;
        }
    }

    /** Handle the key-released event from the text field. */
    public void keyReleased(KeyEvent e) {
        displayInfo(e, "KEY RELEASED: ");
    }

    private void upKeyPressed(KeyEvent e) {

    }

    private void downKeyPressed(KeyEvent e) {
        handler.processEvent(e);
    }

    private void leftKeyPressed(KeyEvent e) {

    }

    private void rightKeyPressed(KeyEvent e) {

    }

    private void displayInfo(KeyEvent e, String keyStatus){

        //You should only rely on the key char if the event
        //is a key typed event.
        int id = e.getID();
        String keyString;
        if (id == KeyEvent.KEY_TYPED) {
            char c = e.getKeyChar();
            keyString = "key character = '" + c + "'";
        } else {
            int keyCode = e.getKeyCode();
            keyString = "key code = " + keyCode
                    + " ("
                    + KeyEvent.getKeyText(keyCode)
                    + ")";
        }

        int modifiersEx = e.getModifiersEx();
        String modString = "extended modifiers = " + modifiersEx;
        String tmpString = KeyEvent.getModifiersExText(modifiersEx);
        if (tmpString.length() > 0) {
            modString += " (" + tmpString + ")";
        } else {
            modString += " (no extended modifiers)";
        }

        String actionString = "action key? ";
        if (e.isActionKey()) {
            actionString += "YES";
        } else {
            actionString += "NO";
        }

        String locationString = "key location: ";
        int location = e.getKeyLocation();
        if (location == KeyEvent.KEY_LOCATION_STANDARD) {
            locationString += "standard";
        } else if (location == KeyEvent.KEY_LOCATION_LEFT) {
            locationString += "left";
        } else if (location == KeyEvent.KEY_LOCATION_RIGHT) {
            locationString += "right";
        } else if (location == KeyEvent.KEY_LOCATION_NUMPAD) {
            locationString += "numpad";
        } else { // (location == KeyEvent.KEY_LOCATION_UNKNOWN)
            locationString += "unknown";
        }

        System.out.println(keyStatus + "----" + keyString + "----" + modString + "----" + actionString + "----" + locationString);

    }
}
