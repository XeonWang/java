package xeon.tank.vehicle;

import xeon.tank.DrawPanel;
import xeon.tank.abs.MoveAbleComponent;
import xeon.tank.abs.PaintableProcesser;
import xeon.tank.bullet.Bullet;
import xeon.tank.util.Direction;

import javax.imageio.ImageIO;
import javax.swing.Timer;
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
    private Random random = new Random((long)(Math.random() * 1000));

    public DefaultTank(DrawPanel paper, Point position, int width, int height) {
        super(paper, position, width, height, image);
    }

    public DefaultTank(DrawPanel paper, Point position, int width, int height, BufferedImage image) {
        super(paper, position, width, height, image);
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

    @Override
    public void processMove(MoveAbleComponent comp, Point position) {
        if (comp instanceof Bullet) {
            getBulletProcesser().processMove(comp, position);
        } else {
            comp.denied();
        }
    }

    @Override
    public void setNextProcesser(PaintableProcesser nextProcesser) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void end() {
        super.end();
        ((TankManager)getManager()).removeListener(this);
    }

    @Override
    public void denied() {
        this.denied = true;
    }

    private void autoMove() {
        if (random.nextInt(6) == 3) {
            pointTo(randDirection());
        } else {
            moveNextStep();
            if (denied) {
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

    private boolean ifFire() {
        return random.nextInt(8) == 5;
    }

}
