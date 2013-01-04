package xeon.tank.wall;

import xeon.tank.DrawPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * User: xeon
 * Date: 12/30/12
 * Time: 5:21 PM
 */
public class DefaultWall extends Wall {

    public static BufferedImage image;
    static {
        try {
            image = ImageIO.read(new File("sources/defaultWall.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public DefaultWall(DrawPanel paper, Point position, int width, int height) {
        super(paper, position, width, height);
        setImage(image);
    }

}
