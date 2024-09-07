package org.example.engine;

import org.example.engine.Camera.CameraInfo;
import org.example.engine.GameMap.GameMap;
import org.example.engine.GameMap.GameMapGenerator;
import org.example.engine.Graphics.ComponentInitializer;
import org.example.engine.Graphics.GameMapPanel;
import org.example.engine.Graphics.MainFrame;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game {
    private final MainFrame mainFrame;
    private final GameMap currentMap;
    private final GameMapPanel currentGameMapPanel;
    private final CameraInfo cameraInfo;
    private final Timer gameTimer;
    private int refreshDelay;
    public Game() {
        this.mainFrame = ComponentInitializer.MainFrame();
        this.currentMap = GameMapGenerator.generateGameMap(200, 200);
        this.currentGameMapPanel = new GameMapPanel(this.currentMap.getFields());
        this.cameraInfo = new CameraInfo();
        this.refreshDelay = 8;
        // Timer
        this.gameTimer = new Timer(this.refreshDelay, e -> {
            if (this.cameraInfo.cameraMovement.moveLeft) {
                this.currentGameMapPanel.moveFields(this.cameraInfo.cameraMoveSpeed, 0);
            }
            if (this.cameraInfo.cameraMovement.moveRight) {
                this.currentGameMapPanel.moveFields(-this.cameraInfo.cameraMoveSpeed, 0);
            }
            if (this.cameraInfo.cameraMovement.moveUp) {
                this.currentGameMapPanel.moveFields(0, this.cameraInfo.cameraMoveSpeed);
            }
            if (this.cameraInfo.cameraMovement.moveDown) {
                this.currentGameMapPanel.moveFields(0, -this.cameraInfo.cameraMoveSpeed);
            }
            this.currentGameMapPanel.repaint();
        });
    }

    private void initilaize() {
        // Key listeners
        this.mainFrame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_LEFT) {
                    cameraInfo.cameraMovement.moveLeft = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    cameraInfo.cameraMovement.moveRight = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_UP) {
                    cameraInfo.cameraMovement.moveUp = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_DOWN) {
                    cameraInfo.cameraMovement.moveDown = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_LEFT) {
                    cameraInfo.cameraMovement.moveLeft = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    cameraInfo.cameraMovement.moveRight = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_UP) {
                    cameraInfo.cameraMovement.moveUp = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_DOWN) {
                    cameraInfo.cameraMovement.moveDown = false;
                }
            }
        });

        // Components
        this.mainFrame.add(this.currentGameMapPanel);
    }

    public void run() {
        this.initilaize();
        this.mainFrame.setVisible(true);
        this.gameTimer.start();
    }
}
