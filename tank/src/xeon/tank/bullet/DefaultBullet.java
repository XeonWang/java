package xeon.tank.bullet;

import xeon.tank.DrawPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * User: xeon
 * Date: 1/4/13
 * Time: 11:16 AM
 */
public class DefaultBullet extends Bullet {

    public static BufferedImage image;
    static {
        try {
            image = ImageIO.read(new File("sources/defaultBullet.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public DefaultBullet(Point position, DrawPanel paper, int width, int height) {
        super(position, paper, width, height);
        setImage(image);
    }

    @Override
    public void denied() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void destroy() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
