package org.example;

import org.example.engine.GameMap.GameMapGenerator;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        var map = GameMapGenerator.generateGameMap(10, 10);
        System.out.println(map);
    }
}
