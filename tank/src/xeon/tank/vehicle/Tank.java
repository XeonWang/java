package xeon.tank.vehicle;

import xeon.tank.abs.AbstractComponent;
import xeon.tank.DrawPanel;
import xeon.tank.abs.MoveAbleComponent;
import xeon.tank.abs.Observer;
import xeon.tank.abs.PaintAble;

import xeon.tank.bullet.BulletManager;
import xeon.tank.util.ImageHelper;

import javax.swing.JComponent;
import java.awt.Point;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.List;

/**
 * User: xeon
 * Date: 12/30/12
 * Time: 9:35 PM
 */
public abstract class Tank extends MoveAbleComponent implements Observer {

    private Direction direction = Direction.NORTH;

    public Tank(DrawPanel paper, Point position, int width, int height) {
        super(position, paper, width, height);
    }

    public void pointTo(Direction direction) {
        int rotateDegree = direction.getValue() - (this.direction.getValue() % 360);
        rotateDegree = rotateDegree < 0 ? rotateDegree + 360 : rotateDegree;
        switch (rotateDegree){
            case 90:
                setImage(ImageHelper.rotate90ToRight(getImage()));
                break;
            case 180:
                setImage(ImageHelper.rotate180(getImage()));
                break;
            case 270:
                setImage(ImageHelper.rotate90ToLeft(getImage()));
                break;
        }
        this.direction = this.direction.rotate(rotateDegree);
        clean();
        paint();
    }

    public void addOperateListener() {
        if (paper instanceof DrawPanel) {
            ((DrawPanel)paper).register(this);
        }
    }

    @Override
    public void update(InputEvent event) {
//        gotoPosition(new Point(position.x, position.y + height/2));
        if (event instanceof KeyEvent) {
            switch (((KeyEvent)event).getKeyCode()) {
                case 32 :
                    spaceKeyPressed();
                    break;
                case 37 :
                    leftKeyPressed();
                    break;
                case 38 :
                    upKeyPressed();
                    break;
                case 39 :
                    rightKeyPressed();
                    break;
                case 40 :
                    downKeyPressed();
                    break;
            }
        }
    }

    private void spaceKeyPressed() {
        for (PaintAble paintAble : paper.getPaintAbles()) {
            if (paintAble instanceof BulletManager) {
                ((BulletManager) paintAble).createBullet(this);
            }
        }
    }

    private void upKeyPressed() {
        if (this.direction != Direction.NORTH){
            pointTo(Direction.NORTH);
        } else {
            processMove(new Point(position.x, position.y - height/2));
        }
    }

    private void downKeyPressed() {
        if (this.direction != Direction.SOUTH) {
            pointTo(Direction.SOUTH);
        } else {
            processMove(new Point(position.x, position.y + height/2));
        }
    }

    private void leftKeyPressed() {
        if (this.direction != Direction.WEST) {
            pointTo(Direction.WEST);
        } else {
            processMove(new Point(position.x - width/2, position.y));
        }
    }

    private void rightKeyPressed() {
        if (this.direction != Direction.EAST) {
            pointTo(Direction.EAST);
        } else {
            processMove(new Point(position.x + width/2, position.y));
        }
    }

    public Direction getDirection() {
        return direction;
    }
}
