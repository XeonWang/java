package xeon.tank.processer;

import xeon.tank.abs.MoveAbleComponent;
import xeon.tank.bullet.Bullet;
import xeon.tank.vehicle.Tank;

import java.awt.*;

/**
 * User: xeon
 * Date: 1/7/13
 * Time: 3:07 PM
 */
public class DefaultBulletProcesser extends BulletProcesser {

    public DefaultBulletProcesser(Tank tank) {
        super(tank);
    }

    @Override
    public void processMove(MoveAbleComponent comp, Point position) {
        if (getTank().getTeam() != ((Bullet)comp).getOwner().getTeam()) {
            comp.destroy();
            getTank().destroy();
        }
    }
}
