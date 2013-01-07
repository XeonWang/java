package xeon.tank.abs;

import xeon.tank.processer.MoveProcesser;


/**
 * User: xeon
 * Date: 1/4/13
 * Time: 11:42 AM
 */
public interface PaintableProcesser extends PaintAble, MoveProcesser{

    public void setNextProcesser(PaintableProcesser nextProcesser);

}
