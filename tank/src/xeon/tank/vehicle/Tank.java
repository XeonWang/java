package xeon.tank.vehicle;

import xeon.tank.abs.AbstractComponent;
import xeon.tank.DrawPanel;
import xeon.tank.abs.Observer;
import xeon.tank.util.ImageHelper;

import javax.swing.JComponent;
import java.awt.Point;

/**
 * User: xeon
 * Date: 12/30/12
 * Time: 9:35 PM
 */
public abstract class Tank extends AbstractComponent implements Observer {

    private int rotation = 0;

    public Tank(JComponent paper, Point position, int width, int height) {
        super(position, paper, width, height);
    }

    public void gotoPosition(Point position) {
        clean();
        setPosition(position);
        paint();
    }

    public void pointTo(Direction direction) {
        rotation %= 360;
        int rotateDegree = rotation - direction.getValue();
        switch (rotateDegree){
            case 90:
                rotate90ToRight();
                break;
            case 180:
                rotate180();
                break;
            case 270:
                rotate90ToLeft();
                break;
        }
        paint();
    }

    public void addOperateListener() {
        if (paper instanceof DrawPanel) {
            ((DrawPanel)paper).register(this);
        }
    }

    private void rotate180() {
        setImage(ImageHelper.rotate180(getImage()));
        rotation += 180;
    }

    private void rotate90ToLeft() {
        setImage(ImageHelper.rotate90ToLeft(getImage()));
        rotation += 270;
    }

    private void rotate90ToRight() {
        setImage(ImageHelper.rotate90ToRight(getImage()));
        rotation += 90;
    }

}
