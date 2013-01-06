package xeon.tank.abs;

import java.awt.event.InputEvent;

/**
 * User: xeon
 * Date: 12/31/12
 * Time: 3:36 PM
 */
public interface EventHandler {
    public void processEvent(InputEvent event);
    public void register(Observer observer);
    public void remove(Observer observer);
}
