package xeon.tank.wall;

import xeon.tank.DrawPanel;
import xeon.tank.abs.AbstractComponent;
import xeon.tank.abs.Manager;
import xeon.tank.abs.MoveAbleComponent;
import xeon.tank.abs.PaintableProcesser;
import xeon.tank.bullet.Bullet;
import xeon.tank.vehicle.Tank;

import java.awt.Graphics;
import java.awt.Point;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * User: xeon
 * Date: 12/30/12
 * Time: 5:25 PM
 */
public class WallManager implements Manager<Wall>, PaintableProcesser {

    private static int itemWidth = 20;
    private static int itemHeight = 20;

    private Wall[][] items;
    private PaintableProcesser nextProcesser;

    public WallManager(DrawPanel paper) {
        int lineNum = paper.getHeight()/itemHeight;
        int columnNum =  paper.getWidth()/itemWidth;
        items = new Wall[lineNum][columnNum];
        File configer = new File("sources/wall.cfg");

        try {
            loadWalls(configer, paper);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadWalls(File configFile, DrawPanel paper) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader(configFile));
        String[] defaultWalls = properties.getProperty("default_walls").split(" ");
        String[] conds;
        Wall wall;
        for (String str : defaultWalls) {
            conds = str.split(",");
            int lineNum = Integer.parseInt(conds[0]);
            int columnNum = Integer.parseInt(conds[1]);
            wall = new DefaultWall(paper, new Point(itemWidth * columnNum, itemHeight * lineNum), itemWidth, itemHeight);
            wall.setManager(this);
            items[lineNum][columnNum] = wall;
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
            if (comp instanceof Tank){
                comp.denied();
            } else if (comp instanceof Bullet) {
                comp.destroy();
            }
            return;
        }

        if (nextProcesser != null) {
            nextProcesser.processMove(comp, position);
        } else {
            comp.move(position);
        }
    }

    @Override
    public void destroyItem(AbstractComponent<Wall> wall) {
        for (int i = 0; i < items.length; i++) {
            for (int j = 0; j < items[i].length; j++) {
                if (items[i][j] == wall) {
                    items[i][j].end();
                    items[i][j] = null;
                }
            }
        }
    }

    private Wall ifClash(int x, int y) {
        return items[y / itemHeight][x / itemWidth];
    }

    public void setNextProcesser(PaintableProcesser nextProcesser) {
        this.nextProcesser = nextProcesser;
    }

}
