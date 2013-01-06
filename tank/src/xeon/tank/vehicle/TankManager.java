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
public class TankManager extends MoveAbleManager implements Manager<Tank>, MoveProcesser {

    public TankManager(DrawPanel paper) {
        super(paper);
        items = new ArrayList<MoveAbleComponent>();

        Tank controledTank = new ControledTank(paper, new Point(400, 300), 40, 40);
        items.add(controledTank);
        controledTank.setManager(this);

        registerListener(controledTank);

        Tank tank1 = new DefaultTank(paper, new Point(60, 60), 40, 40);
        Tank tank2 = new DefaultTank(paper, new Point(100, 80), 40, 40);
        items.add(tank1);
        items.add(tank2);
        tank1.setManager(this);
        tank2.setManager(this);
        try {
            tank1.go();
            tank2.go();
        } catch (UnsupportedOperationException e) {
            e.printStackTrace();
        }
    }

    public void registerListener(Observer observer) {
        getPaper().register(observer);
    }

    public void removeListener(Observer observer) {
        getPaper().remove(observer);
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
    public void destroyItem(Tank tank) {
        tank.end();
        items.remove(tank);
    }
}
