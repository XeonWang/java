package xeon.tank.abs;

import java.awt.Point;

/**
 * User: xeon
 * Date: 1/4/13
 * Time: 11:42 AM
 */
public interface MoveProcesser extends PaintAble{
    public Boolean processMove(MoveAbleComponent comp, Point position);
}