package xeon.tank.wall;

import xeon.tank.DrawPanel;
import xeon.tank.abs.AbstractComponent;
import xeon.tank.abs.MoveProcesser;

import java.awt.Point;
import java.awt.image.BufferedImage;

/**
 * User: xeon
 * Date: 12/30/12
 * Time: 5:19 PM
 */
public abstract class Wall extends AbstractComponent implements MoveProcesser {

    public Wall(DrawPanel paper, Point position, int width, int height, BufferedImage image) {
        super(position, paper, width, height, image);
    }

}
