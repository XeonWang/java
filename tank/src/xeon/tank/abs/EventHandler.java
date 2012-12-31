package xeon.tank.abs;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/**
 * User: xeon
 * Date: 12/31/12
 * Time: 3:36 PM
 */
public interface EventHandler {
    public void processEvent(InputEvent event);
    public void register(Observer observer);
}
