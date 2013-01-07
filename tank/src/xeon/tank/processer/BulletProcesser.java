package xeon.tank.processer;

import xeon.tank.vehicle.Tank;


/**
 * User: xeon
 * Date: 1/7/13
 * Time: 2:44 PM
 */
public abstract class BulletProcesser implements MoveProcesser {

    private Tank tank;

    public BulletProcesser(Tank tank) {
        this.tank = tank;
    }

    public Tank getTank() {
        return tank;
    }
}
