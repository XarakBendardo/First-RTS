package org.example.engine.GameMap;

import lombok.Getter;

public class GameMap {
    private final GameMapField[][] fields;

    @Getter
    private final int width, height;

    GameMap(GameMapField[][] fields, final int width, final int height) {
        this.fields = fields;
        this.width = width;
        this.height = height;
    }

    public GameMapField getField(final int x, final int y) {
        return this.fields[y][x];
    }

    public void setField(final int x, final int y, final GameMapField field) {
        this.fields[y][x] = field;
    }

    @Override
    public String toString() {
        var builder = new StringBuilder();
        for(var y = 0; y < this.height; ++y) {
            for(var x = 0; x < this.width; ++x) {
                builder.append(GameMapField.fieldType2Char.get(this.fields[y][x].getFieldType()));
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
