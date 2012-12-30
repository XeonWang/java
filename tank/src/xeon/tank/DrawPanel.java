package xeon.tank;

import xeon.tank.abs.PaintAble;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * User: xeon
 * Date: 12/30/12
 * Time: 5:38 PM
 */

class DrawPanel extends JPanel {

    private List<PaintAble> paintAbles = new ArrayList<PaintAble>();

    public DrawPanel(int width, int height) {
        setSize(width, height);
    }

    public void addComponent(PaintAble comp) {
        paintAbles.add(comp);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (PaintAble paintAble : paintAbles) {
            paintAble.setGraphics(g);
            paintAble.paint();
        }
    }
}