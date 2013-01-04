package xeon.tank.bullet;

import xeon.tank.DrawPanel;
import xeon.tank.abs.AbstractComponent;
import xeon.tank.abs.MoveAbleComponent;
import xeon.tank.vehicle.Direction;

import javax.swing.*;
import java.awt.*;

/**
 * User: xeon
 * Date: 1/4/13
 * Time: 11:10 AM
 */
public abstract class Bullet extends MoveAbleComponent {

    private Direction direction;

    protected Bullet(Point position, DrawPanel paper, int width, int height, Direction direction) {
        super(position, paper, width, height);
        this.direction = direction;
    }

    public void go() {
        final Bullet bullet = this;
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        bullet.processMove(new Point(bullet.getPosition().x, bullet.getPosition().y - 5));
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

}
