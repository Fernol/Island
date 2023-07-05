package com.javarush.island.engine;

import com.javarush.island.animals.Animal;

public class Island {

    private static Cell[][] listCell = arrayInitialization();
    private static Animal targetAnimal;

    private static Cell[][] arrayInitialization() {
        Cell[][] array = new Cell[Configuration.getNumberCellX()][Configuration.getNumberCellY()];

        for (int x = 0; x < Configuration.getNumberCellX(); x++) {
            for (int y = 0; y < Configuration.getNumberCellY(); y++) {
                array[x][y] = new Cell(x, y);
            }
        }

        return array;
    }

    public static void start() {

    }

}
