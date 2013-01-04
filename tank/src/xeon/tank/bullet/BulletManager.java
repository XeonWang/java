package xeon.tank.bullet;

import xeon.tank.DrawPanel;
import xeon.tank.abs.MoveAbleComponent;
import xeon.tank.abs.MoveAbleManager;
import xeon.tank.abs.MoveProcesser;

import java.awt.Point;

/**
 * User: xeon
 * Date: 1/4/13
 * Time: 11:20 AM
 */
public class BulletManager extends MoveAbleManager implements MoveProcesser {

    protected BulletManager(DrawPanel paper) {
        super(paper);
    }

    @Override
    public Boolean processMove(MoveAbleComponent comp, Point position) {
        //TODO
        return null;
    }
}
