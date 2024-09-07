package org.example.engine.GameMap;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class PaintingManager {
    /*
    * Returns a graphical representation of an instance of GameMap class.
    */
    public static JPanel GameMapPanel(GameMap gameMap) {
        var mapPanel = new JPanel() {
            @Override
            protected void paintComponent(java.awt.Graphics g) {
                super.paintComponent(g);
                BufferedImage image;
                for(var y = 0; y < gameMap.getHeight(); ++y) {
                    for(var x = 0; x < gameMap.getWidth(); ++x) {
                        switch (gameMap.getField(x, y).getFieldType()) {
                            case WATER -> image = Graphics.GameMapFields.Water();
                            case GRASS -> image = Graphics.GameMapFields.Grass();
                            case ROCK -> image = Graphics.GameMapFields.Rock();
                            default -> image = Graphics.GameMapFields.Dirt();
                        }
                        g.drawImage(image, x * image.getWidth(), y * image.getHeight(), null);
                    }
                }
            }
        };
        mapPanel.setPreferredSize(new Dimension(
                gameMap.getWidth() * Graphics.GameMapFields.FIELD_SIZE,
                gameMap.getHeight() * Graphics.GameMapFields.FIELD_SIZE
        ));
        return mapPanel;
    }
}
