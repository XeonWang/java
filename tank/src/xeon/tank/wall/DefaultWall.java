package xeon.tank.wall;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * User: xeon
 * Date: 12/30/12
 * Time: 5:21 PM
 */
public class DefaultWall extends Wall {

    public static Image image;
    static {
        try {
            image = ImageIO.read(new File("sources/defaultWall.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public DefaultWall(JComponent paper, Point position, int width, int height) {
        super(paper, position, width, height);
        setImage(image);
    }

}
