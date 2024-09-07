package org.example.engine.GameMap;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Graphics {
    public static class GameMapFields {
        static {
            try {
                dirtImage = ImageIO.read(new File("C:\\Users\\Marcin\\IdeaProjects\\First-RTS\\src\\main\\resources\\sprites\\GameMap\\Dirt.png"));
                grassImage = ImageIO.read(new File("C:\\Users\\Marcin\\IdeaProjects\\First-RTS\\src\\main\\resources\\sprites\\GameMap\\Grass.png"));
                waterImage = ImageIO.read(new File("C:\\Users\\Marcin\\IdeaProjects\\First-RTS\\src\\main\\resources\\sprites\\GameMap\\Water.png"));
                rockImage = ImageIO.read(new File("C:\\Users\\Marcin\\IdeaProjects\\First-RTS\\src\\main\\resources\\sprites\\GameMap\\Rock.png"));

            } catch (IOException e) {
                throw new RuntimeException("Failed to initialize graphics.");
            }
        }
        private static final BufferedImage dirtImage, grassImage, waterImage, rockImage;

        public static final int FIELD_SIZE = 16;

        public static BufferedImage Dirt() {
            return dirtImage;
        }

        public static BufferedImage Grass() {
            return grassImage;
        }

        public static BufferedImage Water() {
            return waterImage;
        }

        public static BufferedImage Rock() {
            return rockImage;
        }
    }
}
