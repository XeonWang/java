package xeon.tank.vehicle;

import xeon.tank.abs.PaintAble;

import javax.swing.*;
import java.awt.Point;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/**
 * User: xeon
 * Date: 12/30/12
 * Time: 10:20 PM
 */
public class TankManager implements PaintAble {

    private List<Tank> items;
    private JComponent paper;

    public TankManager(JComponent paper) {
        this.paper = paper;
        items = new ArrayList<Tank>();
        Tank tank = new DefaultTank(paper, new Point(400, 300), 40, 40);
        items.add(tank);
    }

    @Override
    public void paint() {
        for (Tank tank : items) {
            tank.begin();
        }
    }

    @Override
    public void clean() {
        for (Tank tank : items) {
            tank.clean();
        }
    }

    @Override
    public void setGraphics(Graphics graphics) {
        for (Tank tank : items) {
            tank.setGraphics(graphics);
        }
    }

    public List<Tank> getItems() {
        return items;
    }

}
