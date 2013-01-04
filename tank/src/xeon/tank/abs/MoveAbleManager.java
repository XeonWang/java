package xeon.tank.abs;

import xeon.tank.DrawPanel;
import xeon.tank.vehicle.Tank;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * User: xeon
 * Date: 1/4/13
 * Time: 1:34 PM
 */
public abstract class MoveAbleManager implements MoveProcesser {

    private DrawPanel paper;
    protected List<MoveAbleComponent> items;

    protected MoveAbleManager(DrawPanel paper) {
        this.paper = paper;
    }

    public void installMoveProcesser() {
        List<MoveProcesser> processers = moveProcessersfilter(paper.getPaintAbles());
        for (MoveAbleComponent comp : items) {
            comp.setProcessers(processers);
        }
    }

    private List<MoveProcesser> moveProcessersfilter(List<PaintAble> paintAbles) {
        List<MoveProcesser> processers = new ArrayList<MoveProcesser>();
        for (PaintAble paintAble : paintAbles) {
            if (paintAble instanceof MoveProcesser) {
                processers.add((MoveProcesser) paintAble);
            }
        }
        return processers;
    }

    @Override
    public void paint() {
        for (MoveAbleComponent comp : items) {
            comp.begin();
        }
    }

    @Override
    public void clean() {
        for (MoveAbleComponent tank : items) {
            tank.clean();
        }
    }

    @Override
    public void setGraphics(Graphics graphics) {
        for (MoveAbleComponent tank : items) {
            tank.setGraphics(graphics);
        }
    }

    public List<MoveAbleComponent> getItems() {
        return items;
    }
}
