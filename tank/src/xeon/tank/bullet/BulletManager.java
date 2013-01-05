package xeon.tank.bullet;

import xeon.tank.DrawPanel;
import xeon.tank.abs.MoveAbleComponent;
import xeon.tank.abs.MoveAbleManager;
import xeon.tank.abs.MoveProcesser;
import xeon.tank.vehicle.Tank;

import java.awt.Point;
import java.util.ArrayList;

/**
 * User: xeon
 * Date: 1/4/13
 * Time: 11:20 AM
 */
public class BulletManager extends MoveAbleManager implements MoveProcesser {

    public BulletManager(DrawPanel paper) {
        super(paper);
        items = new ArrayList<MoveAbleComponent>();
    }

    public void createBullet(Tank tank) {
        Bullet bullet = new DefaultBullet(tank, getPaper(), 10, 20);
        bullet.setProcesser(getCompProcesser());
        bullet.setGraphics(getCompGraphics());
        bullet.pointTo(tank.getDirection());
        items.add(bullet);
        bullet.go();
    }

    @Override
    public void processMove(MoveAbleComponent comp, Point position) {
        //TODO
        if (nextProcesser != null) {
            nextProcesser.processMove(comp, position);
        } else {
            comp.move(position);
        }
    }
}
