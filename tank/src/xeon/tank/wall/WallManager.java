package xeon.tank.wall;

import xeon.tank.DrawPanel;
import xeon.tank.abs.Manager;
import xeon.tank.abs.MoveAbleComponent;
import xeon.tank.abs.MoveProcesser;

import java.awt.Graphics;
import java.awt.Point;

/**
 * User: xeon
 * Date: 12/30/12
 * Time: 5:25 PM
 */
public class WallManager implements Manager, MoveProcesser {

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
            wall.setManager(this);
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

    @Override
    public void processMove(MoveAbleComponent comp, Point position) {

        double widthMul = comp.getWidth() / (double)itemWidth;
        double heightMul = comp.getHeight() / (double)itemHeight;
        try {
            for (int i = 1; i < widthMul + 1; i++) {
                for (int j = 1; j < heightMul + 1; j++) {
                    Wall wall = ifClash(position.x, position.y);
                    if (wall == null) {
                        wall = ifClash(position.x + itemWidth * i - 1, position.y);
                    }
                    if (wall == null) {
                        wall = ifClash(position.x, position.y + itemHeight * j - 1);
                    }
                    if (wall == null) {
                        wall = ifClash(position.x + itemWidth * i - 1, position.y + itemHeight * j - 1);
                    }
                    if (wall != null) {
                        wall.processMove(comp, position);
                        return;
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            comp.denied();
            return;
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

    private Wall ifClash(int x, int y) {
        return items[y / itemHeight][x / itemWidth];
    }

    @Override
    public void destroyItem(Object wall) {
        if (!(wall instanceof Wall)) return;
        for (int i = 0; i < items.length; i++) {
            for (int j = 0; j < items[i].length; j++) {
                if (items[i][j] == wall) {
                    items[i][j].end();
                    items[i][j] = null;
                }
            }
        }
    }
}
