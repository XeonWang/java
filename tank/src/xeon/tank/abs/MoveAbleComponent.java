package xeon.tank.abs;

import xeon.tank.DrawPanel;

import java.awt.Point;
import java.awt.image.BufferedImage;

/**
 * User: xeon
 * Date: 1/4/13
 * Time: 11:26 AM
 */
public abstract class MoveAbleComponent extends AbstractComponent {

    private PaintableProcesser processer = null;

    public MoveAbleComponent(Point position, DrawPanel paper, int width, int height, BufferedImage image) {
        super(position, paper, width, height, image);
    }

    public void processMove(Point position) {
        processer.processMove(this, position);
    }

    public void setProcesser(PaintableProcesser processer) {
        this.processer = processer;
    }

    public void move(Point position) {
        clean();
        setPosition(position);
        paint();
    }

    public abstract void denied();

}
