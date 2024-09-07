package org.example.engine.GameMap;

import lombok.Getter;

import java.util.Map;

public class GameMapField {
    public enum FieldType {
        DIRT, GRASS, FOREST, ROCK, WATER
    }

    public static final Map<FieldType, Character> fieldType2Char = Map.of(
            FieldType.DIRT, 'd',
            FieldType.GRASS, 'g',
            FieldType.FOREST, 'f',
            FieldType.ROCK, 'r',
            FieldType.WATER, 'w'
    );

    @Getter
    private final FieldType fieldType;

    private GameMapField(final FieldType fieldType) {
        this.fieldType = fieldType;
    }

    public static GameMapField of(final FieldType fieldType) {
        return new GameMapField(fieldType);
    }
}
