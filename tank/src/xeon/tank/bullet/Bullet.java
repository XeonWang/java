package xeon.tank.bullet;

import xeon.tank.DrawPanel;
import xeon.tank.abs.AbstractComponent;
import xeon.tank.abs.Autoable;
import xeon.tank.abs.DirectableComponent;
import xeon.tank.abs.MoveAbleComponent;
import xeon.tank.vehicle.Direction;
import xeon.tank.vehicle.Tank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * User: xeon
 * Date: 1/4/13
 * Time: 11:10 AM
 */
public abstract class Bullet extends DirectableComponent implements Autoable {

    private Timer timer;

    protected Bullet(Point position, DrawPanel paper, int width, int height) {
        super(position, paper, width, height);
        direction = Direction.NORTH;
    }

    protected Bullet(Tank tank, DrawPanel paper, int width, int height) {
        this(new Point(), paper, width, height);
        Point position = null;
        switch (tank.getDirection().getValue() % 360) {
            case 0 :
                 position = new Point(tank.getPosition().x + (tank.getWidth() - width) / 2, tank.getPosition().y - height);
                break;
            case 90 :
                position = new Point(tank.getPosition().x + tank.getWidth(), tank.getPosition().y + (tank.getHeight() - width) / 2);
                break;
            case 180 :
                position = new Point(tank.getPosition().x + (tank.getWidth() - width) / 2, tank.getPosition().y + tank.getHeight());
                break;
            case 270 :
                position = new Point(tank.getPosition().x - height, tank.getPosition().y + (tank.getHeight() - width) / 2);
                break;
        }
        setPosition(position);
    }

    @Override
    public void go() {
        final Bullet bullet = this;
        timer = new Timer(50, new ActionListener() {
            @Override
            public synchronized void actionPerformed(ActionEvent e) {
                bullet.moveToNext();
            }
        });
        timer.start();
    }

    private void moveToNext() {
        switch (getDirection().getValue() % 360) {
            case 0 :
                processMove(new Point(getPosition().x, getPosition().y - 5));
                break;
            case 90 :
                processMove(new Point(getPosition().x + 5, getPosition().y));
                break;
            case 180 :
                processMove(new Point(getPosition().x, getPosition().y + 5));
                break;
            case 270 :
                processMove(new Point(getPosition().x - 5, getPosition().y));
                break;
        }
    }

    @Override
    public void end() {
        if (timer != null){
            timer.stop();
        }
        super.end();
    }
}
