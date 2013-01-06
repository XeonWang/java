package xeon.tank.abs;

import xeon.tank.DrawPanel;

import java.awt.Graphics;
import java.awt.Point;
import java.util.List;

/**
 * User: xeon
 * Date: 1/4/13
 * Time: 1:34 PM
 */
public abstract class MoveAbleManager implements MoveProcesser {

    private DrawPanel paper;
    protected List<MoveAbleComponent> items;
    protected MoveProcesser nextProcesser;
    private MoveProcesser compProcesser;
    private Graphics compGraphics;

    protected MoveAbleManager(DrawPanel paper) {
        this.paper = paper;
    }

    public void installMoveProcesser(MoveProcesser processer) {
        this.compProcesser = processer;
        for (MoveAbleComponent comp : items) {
            comp.setProcesser(processer);
        }
    }

    @Override
    public void paint() {
        for (MoveAbleComponent comp : items) {
            comp.begin();
        }
    }

    @Override
    public void clean() {
        for (MoveAbleComponent comp : items) {
            comp.clean();
        }
    }

    @Override
    public void setGraphics(Graphics graphics) {
        compGraphics = graphics;
        for (MoveAbleComponent comp : items) {
            comp.setGraphics(graphics);
        }
    }

    public void setNextProcesser(MoveProcesser nextProcesser) {
        this.nextProcesser = nextProcesser;
    }

    protected boolean ifClash(MoveAbleComponent mover, Point position, AbstractComponent target) {
        return inScope(position.x, position.y, target)
                || inScope(position.x + mover.width, position.y, target)
                || inScope(position.x, position.y + mover.height, target)
                || inScope(position.x + mover.width, position.y + mover.height, target);
    }

    private boolean inScope(int x, int y, AbstractComponent target) {
        return x > target.getPosition().x && x < target.getPosition().x + target.width
                && y > target.getPosition().y && y < target.getPosition().y + target.height;
    }

    public DrawPanel getPaper() {
        return paper;
    }

    protected MoveProcesser getCompProcesser() {
        return compProcesser;
    }

    protected Graphics getCompGraphics() {
        return compGraphics;
    }
}
