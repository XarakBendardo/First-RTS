package org.example.engine.GameMap;

import java.util.Random;

public class GameMapGenerator {
    public static GameMap generateGameMap(final int width, final int height) {
        var rnd = new Random();
        var fields = new GameMapField[height][width];
        for(var y = 0; y < height; ++y) {
            for(var x = 0; x < width; ++x) {
                var rndIdx = rnd.nextInt(GameMapField.FieldType.values().length);
                fields[y][x] =  GameMapField.of(GameMapField.FieldType.values()[rndIdx]);
            }
        }
        return new GameMap(fields, width, height);
    }
}
