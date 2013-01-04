package xeon.tank.wall;

import xeon.tank.DrawPanel;
import xeon.tank.abs.AbstractComponent;

import javax.swing.*;
import java.awt.Point;

/**
 * User: xeon
 * Date: 12/30/12
 * Time: 5:19 PM
 */
public abstract class Wall extends AbstractComponent {

    public Wall(DrawPanel paper, Point position, int width, int height) {
        super(position, paper, width, height);
    }

}
