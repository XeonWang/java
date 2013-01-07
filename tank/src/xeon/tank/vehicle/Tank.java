package xeon.tank.vehicle;

import xeon.tank.DrawPanel;

import xeon.tank.abs.*;
import xeon.tank.abs.PaintableProcesser;
import xeon.tank.bullet.BulletManager;
import xeon.tank.processer.BulletProcesser;
import xeon.tank.util.Direction;
import xeon.tank.util.Team;

import javax.swing.Timer;
import java.awt.Point;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

/**
 * User: xeon
 * Date: 12/30/12
 * Time: 9:35 PM
 */
public abstract class Tank extends DirectableComponent implements Observer, Autoable, PaintableProcesser {

    private BulletProcesser bulletProcesser;
    protected Timer timer;

    public Tank(DrawPanel paper, Point position, int width, int height, BufferedImage image) {
        super(position, paper, width, height, image);
        direction = Direction.NORTH;
    }

    @Override
    public void update(InputEvent event) {
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

    }

    @Override
    public void destroy() {
        getManager().destroyItem(this);
    }

    @Override
    public void end() {
        if (timer != null){
            timer.stop();
        }
        super.end();
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

    public Team getTeam() {
        return Team.ANIMY;
    }

    public void setBulletProcesser(BulletProcesser bulletProcesser) {
        this.bulletProcesser = bulletProcesser;
    }

    public BulletProcesser getBulletProcesser() {
        return bulletProcesser;
    }
}
