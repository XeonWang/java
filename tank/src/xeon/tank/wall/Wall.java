package xeon.tank.wall;

import xeon.tank.abs.AbstractComponent;

import javax.swing.*;
import java.awt.*;

/**
 * User: xeon
 * Date: 12/30/12
 * Time: 5:19 PM
 */
public abstract class Wall extends AbstractComponent {

    public Wall(JComponent paper, Point position, int width, int height) {
        super(position, paper, width, height);
    }

}
