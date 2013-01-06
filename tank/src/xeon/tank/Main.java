package xeon.tank;

import xeon.tank.abs.MoveProcesser;
import xeon.tank.bullet.BulletManager;
import xeon.tank.vehicle.TankManager;
import xeon.tank.wall.WallManager;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

/**
 * User: xeon
 * Date: 12/30/12
 * Time: 11:36 AM
 */
public class Main {
    public static void createAndShowGUI(){

        JFrame frame = new JFrame("Tank");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(145, 165, 126));
        menuBar.setPreferredSize(new Dimension(600, 30));

        DrawPanel drawPanel = new DrawPanel(600, 570);

        MoveProcesser wallManager = new WallManager(drawPanel);
        drawPanel.addComponent(wallManager);
        TankManager tankManager = new TankManager(drawPanel);
        drawPanel.addComponent(tankManager);
        BulletManager bulletManager = new BulletManager(drawPanel);
        drawPanel.addComponent(bulletManager);

        wallManager.setNextProcesser(tankManager);
        tankManager.installMoveProcesser(wallManager);
        bulletManager.installMoveProcesser(wallManager);

        drawPanel.setFocusable(true);
        drawPanel.requestFocusInWindow();
        drawPanel.addKeyListener(new OperateListener(drawPanel));

        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(drawPanel, BorderLayout.CENTER);

        frame.pack();
        frame.setSize(600, 600);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
}

