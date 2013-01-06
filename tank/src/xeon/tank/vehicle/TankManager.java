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
public class TankManager extends MoveAbleManager implements Manager, MoveProcesser {

    public TankManager(DrawPanel paper) {
        super(paper);
        items = new ArrayList<MoveAbleComponent>();
        Tank tank = new DefaultTank(paper, new Point(400, 300), 40, 40);
        items.add(tank);
        if (paper instanceof EventHandler) {
            ((EventHandler) paper).register(tank);
        }
        tank = new DefaultTank(paper, new Point(60, 60), 40, 40);
        items.add(tank);
        tank.go();
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

    @Override
    public void destroyItem(Object item) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
