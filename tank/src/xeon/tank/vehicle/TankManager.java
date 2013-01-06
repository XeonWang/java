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

        Tank controledTank = new ControledTank(paper, new Point(400, 300), 40, 40);
        items.add(controledTank);
        controledTank.setManager(this);

        registerListener(controledTank);

        Tank tank = new DefaultTank(paper, new Point(60, 60), 40, 40);
        items.add(tank);
        tank.setManager(this);
        try {
            tank.go();
        } catch (UnsupportedOperationException e) {
            e.printStackTrace();
        }
    }

    public void registerListener(Observer observer) {
        ((EventHandler) getPaper()).register(observer);
    }

    public void removeListener(Observer observer) {
        ((EventHandler) getPaper()).remove(observer);
    }

    @Override
    public void processMove(MoveAbleComponent comp, Point position) {
        for (Object item : items) {
            if (ifClash(comp, position, ((Tank)item))) {
                ((Tank)item).processMove(comp, position);
                break;
            }
        }
        if (nextProcesser != null) {
            nextProcesser.processMove(comp, position);
        } else {
            comp.move(position);
        }
    }

    @Override
    public void destroyItem(Object item) {
        if (item instanceof Tank) {
            ((Tank)item).end();
            items.remove(item);
        }
    }
}
