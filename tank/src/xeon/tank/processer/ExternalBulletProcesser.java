package xeon.tank.processer;

import xeon.tank.abs.MoveAbleComponent;
import xeon.tank.bullet.Bullet;
import xeon.tank.vehicle.Tank;

import java.awt.Point;

/**
 * User: xeon
 * Date: 1/7/13
 * Time: 3:12 PM
 */
public class ExternalBulletProcesser extends BulletProcesser {

    public ExternalBulletProcesser(Tank tank) {
        super(tank);
    }

    @Override
    public void processMove(MoveAbleComponent comp, Point position) {
        if (getTank().getTeam() != ((Bullet)comp).getOwner().getTeam()) {
            comp.destroy();
            getTank().setBulletProcesser(new DefaultBulletProcesser(getTank()));
        }
    }
}
