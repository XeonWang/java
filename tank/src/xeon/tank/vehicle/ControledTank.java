package xeon.tank.vehicle;

import xeon.tank.DrawPanel;
import xeon.tank.abs.MoveAbleComponent;
import xeon.tank.abs.MoveProcesser;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * User: xeon
 * Date: 1/6/13
 * Time: 2:38 PM
 */
public class ControledTank extends DefaultTank {

    public static BufferedImage image;
    static {
        try {
            image = ImageIO.read(new File("sources/controledTank.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ControledTank(DrawPanel paper, Point position, int width, int height) {
        super(paper, position, width, height, image);
    }

}
