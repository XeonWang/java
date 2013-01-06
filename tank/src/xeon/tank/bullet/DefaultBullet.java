package xeon.tank.bullet;

import xeon.tank.DrawPanel;
import xeon.tank.vehicle.Tank;

import javax.imageio.ImageIO;
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

    public DefaultBullet(Tank tank, DrawPanel paper, int width, int height) {
        super(tank, paper, width, height, image);
    }

    @Override
    public void denied() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void destroy() {
        getManager().destroyItem(this);
    }
}
