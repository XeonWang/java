package xeon.tank.abs;

import xeon.tank.DrawPanel;
import xeon.tank.util.ImageHelper;
import xeon.tank.util.Direction;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * User: xeon
 * Date: 1/5/13
 * Time: 3:02 PM
 */
public abstract class DirectableComponent extends MoveAbleComponent {

    protected Direction direction;

    public DirectableComponent(Point position, DrawPanel paper, int width, int height, BufferedImage image) {
        super(position, paper, width, height, image);
        direction = Direction.NORTH;
    }

    public void pointTo(Direction direction) {
        int rotateDegree = direction.getValue() - (this.direction.getValue() % 360);
        rotateDegree = rotateDegree < 0 ? rotateDegree + 360 : rotateDegree;
        switch (rotateDegree){
            case 90:
                setImage(ImageHelper.rotate90ToRight(getImage()));
                int temp = getWidth();
                setWidth(getHeight());
                setHeight(temp);
                break;
            case 180:
                setImage(ImageHelper.rotate180(getImage()));
                break;
            case 270:
                setImage(ImageHelper.rotate90ToLeft(getImage()));
                temp = getWidth();
                setWidth(getHeight());
                setHeight(temp);
                break;
        }
        this.direction = this.direction.rotate(rotateDegree);
        clean();
        paint();
    }

    public Direction getDirection() {
        return direction;
    }

}
