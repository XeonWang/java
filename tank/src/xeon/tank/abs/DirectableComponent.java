package xeon.tank.abs;

import xeon.tank.DrawPanel;
import xeon.tank.util.ImageHelper;
import xeon.tank.vehicle.Direction;

import java.awt.*;

/**
 * User: xeon
 * Date: 1/5/13
 * Time: 3:02 PM
 */
public abstract class DirectableComponent extends MoveAbleComponent {

    protected Direction direction;

    protected DirectableComponent(Point position, DrawPanel paper, int width, int height) {
        super(position, paper, width, height);
        direction = Direction.NORTH;
    }

    public void pointTo(Direction direction) {
        int rotateDegree = direction.getValue() - (this.direction.getValue() % 360);
        rotateDegree = rotateDegree < 0 ? rotateDegree + 360 : rotateDegree;
        switch (rotateDegree){
            case 90:
                setImage(ImageHelper.rotate90ToRight(getImage()));
                int temp = width;
                width = height;
                height = temp;
                break;
            case 180:
                setImage(ImageHelper.rotate180(getImage()));
                break;
            case 270:
                setImage(ImageHelper.rotate90ToLeft(getImage()));
                temp = width;
                width = height;
                height = temp;
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
