package xeon.tank.abs;

import xeon.tank.DrawPanel;

import java.awt.Point;
import java.util.List;

/**
 * User: xeon
 * Date: 1/4/13
 * Time: 11:26 AM
 */
public abstract class MoveAbleComponent extends AbstractComponent {

    private MoveProcesser processer = null;

    protected MoveAbleComponent(Point position, DrawPanel paper, int width, int height) {
        super(position, paper, width, height);
    }

    public void processMove(Point position) {
        processer.processMove(this, position);
    }

    public void setProcesser(MoveProcesser processer) {
        this.processer = processer;
    }

    public void move(Point position) {
        clean();
        setPosition(position);
        paint();
    }

    public abstract void denied();

    public abstract void destroy();

}
