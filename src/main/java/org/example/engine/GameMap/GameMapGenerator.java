package org.example.engine.GameMap;

public class GameMapGenerator {
    public static GameMap generateGameMap(final int width, final int height) {
        var fields = new GameMapField[height][width];
        for(var y = 0; y < height; ++y) {
            for(var x = 0; x < width; ++x) {
                fields[y][x] =  GameMapField.of(GameMapField.FieldType.DIRT);
            }
        }
        return new GameMap(fields, width, height);
    }
}
