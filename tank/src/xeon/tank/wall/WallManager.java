package xeon.tank.wall;

import xeon.tank.abs.PaintAble;

import javax.swing.*;
import java.awt.*;

/**
 * User: xeon
 * Date: 12/30/12
 * Time: 5:25 PM
 */
public class WallManager implements PaintAble {

    private Wall[][] items;
    private JComponent paper;
    private static int itemWidth = 20;
    private static int itemHeight = 20;

    public WallManager(JComponent paper) {
        this.paper = paper;
        items = new Wall[5][10];
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
}
