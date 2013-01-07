package xeon.tank.processer;

import xeon.tank.abs.MoveAbleComponent;

import java.awt.*;

/**
 * User: xeon
 * Date: 1/7/13
 * Time: 2:53 PM
 */
public interface MoveProcesser {

    public void processMove(MoveAbleComponent comp, Point position);

}
