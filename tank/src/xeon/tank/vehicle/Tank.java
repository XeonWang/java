package xeon.tank.vehicle;

import xeon.tank.abs.*;
import xeon.tank.DrawPanel;

import xeon.tank.bullet.BulletManager;

import javax.swing.*;
import java.awt.Point;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/**
 * User: xeon
 * Date: 12/30/12
 * Time: 9:35 PM
 */
public abstract class Tank extends DirectableComponent implements Observer, Autoable, MoveProcesser {

    protected Timer timer;

    public Tank(DrawPanel paper, Point position, int width, int height) {
        super(position, paper, width, height);
        direction = Direction.NORTH;
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

    public void fire(){
        for (PaintAble paintAble : paper.getPaintAbles()) {
            if (paintAble instanceof BulletManager) {
                ((BulletManager) paintAble).createBullet(this);
            }
        }
    }

    @Override
    public void denied() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void destroy() {
        getManager().destroyItem(this);
    }

    private void spaceKeyPressed() {
        fire();
    }

    private void upKeyPressed() {
        if (this.direction != Direction.NORTH){
            pointTo(Direction.NORTH);
        }
        moveNextStep();
    }

    private void downKeyPressed() {
        if (this.direction != Direction.SOUTH) {
            pointTo(Direction.SOUTH);
        }
        moveNextStep();
    }

    private void leftKeyPressed() {
        if (this.direction != Direction.WEST) {
            pointTo(Direction.WEST);
        }
        moveNextStep();
    }

    private void rightKeyPressed() {
        if (this.direction != Direction.EAST) {
            pointTo(Direction.EAST);
        }
        moveNextStep();
    }

    protected void moveNextStep() {
        if (this.direction == Direction.NORTH){
            processMove(new Point(position.x, position.y - height/2));
        } else if (this.direction == Direction.SOUTH) {
            processMove(new Point(position.x, position.y + height/2));
        } else if (this.direction == Direction.WEST) {
            processMove(new Point(position.x - width/2, position.y));
        } else if (this.direction == Direction.EAST) {
            processMove(new Point(position.x + width/2, position.y));
        }
    }

    @Override
    public void end() {
        if (timer != null){
            timer.stop();
        }
        super.end();
    }
}
