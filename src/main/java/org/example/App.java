package org.example;

import org.example.engine.GameMap.GameMapGenerator;
import org.example.engine.GameMap.PaintingManager;

import javax.swing.*;


public class App {
    public static void main(String[] args) {
        var map = GameMapGenerator.generateGameMap(60, 60);
        var frame = new JFrame();
        var mapPanel = PaintingManager.GameMapPanel(map);

        frame.add(mapPanel);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}