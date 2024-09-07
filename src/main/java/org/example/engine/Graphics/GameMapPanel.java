package org.example.engine.Graphics;

import org.example.engine.GameMap.GameMapField;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class GameMapPanel extends JPanel {
    private int mapPositionX, mapPositionY;
    private final GameMapField[][] fields;

    public GameMapPanel(final GameMapField[][] fields) {
        this.fields = fields;
        this.mapPositionX = 0;
        this.mapPositionY = 0;
    }

    @Override
    protected void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        BufferedImage image;
        for(var y = 0; y < this.fields.length; ++y) {
            for(var x = 0; x < this.fields[y].length; ++x) {
                switch (this.fields[y][x].getFieldType()) {
                    case WATER -> image = org.example.engine.Graphics.Graphics.GameMapFields.Water();
                    case GRASS -> image = org.example.engine.Graphics.Graphics.GameMapFields.Grass();
                    case ROCK -> image = org.example.engine.Graphics.Graphics.GameMapFields.Rock();
                    default -> image = org.example.engine.Graphics.Graphics.GameMapFields.Dirt();
                }
                int xPositionOnScreen = this.mapPositionX + x * image.getWidth();
                int yPositionOnScreen = this.mapPositionY + y * image.getHeight();
                g.drawImage(image, xPositionOnScreen, yPositionOnScreen, null);
            }
        }
    }

    public void moveFields(final int x, final int y) {
        this.mapPositionX += x;
        this.mapPositionY += y;
    }
}
