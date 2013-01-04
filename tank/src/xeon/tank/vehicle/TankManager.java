package xeon.tank.vehicle;

import xeon.tank.DrawPanel;
import xeon.tank.abs.*;

import java.awt.Point;
import java.util.ArrayList;

/**
 * User: xeon
 * Date: 12/30/12
 * Time: 10:20 PM
 */
public class TankManager extends MoveAbleManager implements MoveProcesser {

    public TankManager(DrawPanel paper) {
        super(paper);
        items = new ArrayList<MoveAbleComponent>();
        Tank tank = new DefaultTank(paper, new Point(400, 300), 40, 40);
        items.add(tank);
        if (paper instanceof EventHandler) {
            ((EventHandler) paper).register(tank);
        }
    }

    @Override
    public Boolean processMove(MoveAbleComponent comp, Point position) {
        //TODO
        return true;
    }

}
