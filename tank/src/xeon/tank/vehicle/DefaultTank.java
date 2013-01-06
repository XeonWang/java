package xeon.tank.vehicle;

import xeon.tank.DrawPanel;
import xeon.tank.abs.MoveAbleComponent;
import xeon.tank.abs.MoveProcesser;
import xeon.tank.bullet.Bullet;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

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

    private boolean denied;
    private Random random = new Random(System.currentTimeMillis());

    public DefaultTank(DrawPanel paper, Point position, int width, int height) {
        super(paper, position, width, height);
        setImage(image);
    }

    @Override
    public void denied() {
        this.denied = true;
    }

    @Override
    public void go() {
        timer = new Timer(300, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                autoMove();
                if (ifFire()) {
                    fire();
                }
            }
        });
        timer.start();
    }

    private void autoMove() {
        if (random.nextInt(6) == 3) {
            pointTo(randDirection());
        } else {
            moveNextStep();
            if (denied == true) {
                pointTo(randDirection());
                denied = false;
            }
        }
    }

    private Direction randDirection() {
        int r = random.nextInt(3);
        switch (r) {
            case 0:
                return Direction.NORTH;
            case 1:
                return Direction.EAST;
            case 2:
                return Direction.SOUTH;
            case 3:
                return Direction.WEST;
        }
        return null;
    }

    public boolean ifFire() {
        if (random.nextInt(8) == 5) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void processMove(MoveAbleComponent comp, Point position) {
        if (comp instanceof Bullet) {
            comp.destroy();
            destroy();
        } else {
            comp.denied();
        }
    }

    @Override
    public void setNextProcesser(MoveProcesser nextProcesser) {
        throw new UnsupportedOperationException();
    }
}
