package xeon.tank.vehicle;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Point;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

/**
 * User: xeon
 * Date: 12/30/12
 * Time: 10:14 PM
 */
public class DefaultTank extends Tank {

    public static Image image;
    static {
        try {
            image = ImageIO.read(new File("sources/defaultTank.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public DefaultTank(JComponent paper, Point position, int width, int height) {
        super(paper, position, width, height);
        setImage(image);
    }

}
