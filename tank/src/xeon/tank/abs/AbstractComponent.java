package xeon.tank.abs;


import xeon.tank.DrawPanel;

import javax.swing.JComponent;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * User: xeon
 * Date: 12/30/12
 * Time: 9:38 PM
 */
public abstract class AbstractComponent implements PaintAble, Ciycle {

    protected Point position;
    protected DrawPanel paper;
    protected Graphics graphics;
    protected int width;
    protected int height;
    protected BufferedImage image;
    protected Manager manager;

    protected AbstractComponent() {
    }

    public AbstractComponent(Point position, DrawPanel paper, int width, int height, BufferedImage image) {
        this.position = position;
        this.paper = paper;
        this.width = width;
        this.height = height;
        this.image = image;
    }

    @Override
    public void paint() {
        graphics.drawImage(getImage(), position.x, position.y, width, height, null);
        paper.repaint(position.x, position.y, width, height);
    }

    @Override
    public void begin() {
        paint();
    }

    @Override
    public void end() {
        clean();
    }

    @Override
    public void clean() {
        graphics.clearRect(position.x, position.y, width, height);
        paper.repaint(position.x, position.y, width, height);
    }

    public BufferedImage getImage() {
        return image;
    }

    protected void setImage(BufferedImage image) {
        this.image = image;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }

    public Point getPosition() {
        return position;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Manager getManager() {
        return manager;
    }
}
