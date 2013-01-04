package xeon.tank.bullet;

import xeon.tank.DrawPanel;
import xeon.tank.abs.AbstractComponent;
import xeon.tank.abs.MoveAbleComponent;

import javax.swing.*;
import java.awt.*;

/**
 * User: xeon
 * Date: 1/4/13
 * Time: 11:10 AM
 */
public abstract class Bullet extends MoveAbleComponent {

    protected Bullet(Point position, DrawPanel paper, int width, int height) {
        super(position, paper, width, height);
    }

}
