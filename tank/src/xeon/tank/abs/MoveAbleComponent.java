package xeon.tank.abs;

import xeon.tank.DrawPanel;

import javax.swing.JComponent;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 * User: xeon
 * Date: 1/4/13
 * Time: 11:26 AM
 */
public abstract class MoveAbleComponent extends AbstractComponent {

    private List<MoveProcesser> processers = null;

    protected MoveAbleComponent(Point position, DrawPanel paper, int width, int height) {
        super(position, paper, width, height);
    }

    public void gotoPosition(Point position) {
        if (processMove(position) != null) {
            clean();
//          setPosition(position);
            paint();
        }
    }

    protected MoveAbleComponent processMove(Point position) {
        Boolean result = true;
        for (MoveProcesser processer : processers) {
            if (result == null) return null;
            if (result != false) {
                result = processer.processMove(this, position);
            } else {
                return this;
            }
        }
        this.setPosition(position);
        return this;
    }

    public void setProcessers(List<MoveProcesser> processers) {
        this.processers = processers;
    }

}
