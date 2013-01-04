package xeon.tank.vehicle;

import xeon.tank.DrawPanel;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * User: xeon
 * Date: 12/30/12
 * Time: 10:14 PM
 */
public class DefaultTank extends Tank {

    public static BufferedImage image;
    static {
        try {
            image = ImageIO.read(new File("sources/defaultTank.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public DefaultTank(DrawPanel paper, Point position, int width, int height) {
        super(paper, position, width, height);
        setImage(image);
    }

}
