package xeon.tank.vehicle;

import xeon.tank.abs.AbstractComponent;

import javax.swing.*;
import java.awt.Point;

/**
 * User: xeon
 * Date: 12/30/12
 * Time: 9:35 PM
 */
public abstract class Tank extends AbstractComponent {

    public Tank(JComponent paper, Point position, int width, int height) {
        super(position, paper, width, height);
    }

    public void gotoPosition(Point position) {
        clean();
        setPosition(position);
        paint();
    }

}
