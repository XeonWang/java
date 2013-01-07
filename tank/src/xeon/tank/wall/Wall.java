package xeon.tank.wall;

import xeon.tank.DrawPanel;
import xeon.tank.abs.AbstractComponent;
import xeon.tank.abs.PaintableProcesser;

import java.awt.Point;
import java.awt.image.BufferedImage;

/**
 * User: xeon
 * Date: 12/30/12
 * Time: 5:19 PM
 */
public abstract class Wall extends AbstractComponent implements PaintableProcesser {

    public Wall(DrawPanel paper, Point position, int width, int height, BufferedImage image) {
        super(position, paper, width, height, image);
    }

}
