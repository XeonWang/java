package xeon.tank.wall;

import xeon.tank.DrawPanel;
import xeon.tank.abs.MoveAbleComponent;
import xeon.tank.abs.MoveProcesser;
import xeon.tank.abs.PaintAble;

import javax.swing.*;
import java.awt.Graphics;
import java.awt.Point;

/**
 * User: xeon
 * Date: 12/30/12
 * Time: 5:25 PM
 */
public class WallManager implements MoveProcesser {

    private Wall[][] items;
    private DrawPanel paper;
    private MoveProcesser nextProcesser;
    private static int itemWidth = 20;
    private static int itemHeight = 20;

    public WallManager(DrawPanel paper) {
        this.paper = paper;
        int lineNum = paper.getHeight()/itemHeight + 1;
        int columnNum =  paper.getWidth()/itemWidth + 1;
        items = new Wall[lineNum][columnNum];
        for (int i = 0; i < 9; i++) {
            Wall wall = new DefaultWall(paper, new Point(itemWidth * i, itemHeight * 2), itemWidth, itemHeight);
            items[2][i] = wall;
        }
    }

    @Override
    public void paint() {
        for (Wall[] line : items) {
            for (Wall wall : line) {
                if (wall != null) {
                    wall.begin();
                }
            }
        }
    }

    @Override
    public void clean() {
        for (Wall[] line : items) {
            for (Wall wall : line) {
                if (wall != null) {
                    wall.end();
                }
            }
        }
        items = null;
    }

    @Override
    public void setGraphics(Graphics graphics) {
        for (Wall[] line : items) {
            for (Wall wall : line) {
                if (wall != null) {
                    wall.setGraphics(graphics);
                }
            }
        }
    }

    public void destroyItem(int line, int column) {
        if (items[line][column] != null) {
            items[line][column].end();
            items[line][column] = null;
        }
    }

    @Override
    public void processMove(MoveAbleComponent comp, Point position) {

        double widthMul = comp.getWidth() / (double)itemWidth;
        double heightMul = comp.getHeight() / (double)itemHeight;

        for (int i = 1; i < widthMul + 1; i++) {
            for (int j = 1; j < heightMul + 1; j++) {
                if (isClash(position.x, position.y)
                        || isClash(position.x + itemWidth * i, position.y)
                        || isClash(position.x, position.y + itemHeight * j)
                        || isClash(position.x + itemWidth * i, position.y + itemHeight * j)) {
                    comp.denied();
                    return;
                }
            }
        }

        if (nextProcesser != null) {
            nextProcesser.processMove(comp, position);
        } else {
            comp.move(position);
        }
    }

    public void setNextProcesser(MoveProcesser nextProcesser) {
        this.nextProcesser = nextProcesser;
    }

    private boolean isClash(int x, int y) {
        Wall wall;
        try {
            wall = items[y / itemHeight][x / itemWidth];
        } catch (ArrayIndexOutOfBoundsException e) {
            return true;
        }
        return wall != null;
    }
}
