package xeon.tank.abs;

import java.awt.Point;

/**
 * User: xeon
 * Date: 1/4/13
 * Time: 11:42 AM
 */
public interface MoveProcesser extends PaintAble{

    public void processMove(MoveAbleComponent comp, Point position);

    public void setNextProcesser(MoveProcesser nextProcesser);

}
