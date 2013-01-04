package xeon.tank;

import xeon.tank.abs.*;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.InputEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * User: xeon
 * Date: 12/30/12
 * Time: 5:38 PM
 */

public class DrawPanel extends JPanel implements EventHandler {

    private List<PaintAble> paintAbles = new ArrayList<PaintAble>();
    private List<Observer> observers = new ArrayList<Observer>();

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

    @Override
    public void register(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void processEvent(InputEvent event) {
        for (Observer observer : observers) {
            observer.update(event);
        }
    }

    public List<PaintAble> getPaintAbles() {
        return paintAbles;
    }

}