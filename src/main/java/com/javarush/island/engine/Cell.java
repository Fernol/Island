package com.javarush.island.engine;

import com.javarush.island.animals.Entity;

import java.util.HashSet;
import java.util.Set;

public class Cell {
    private int x;
    private int y;
    private Set<Entity> entitiesInCell = new HashSet<>();

    public void addOnSetEntities(Entity entity) {
        entitiesInCell.add(entity);
    }

    public void removeOnSetEntities(Entity entity) {
        entitiesInCell.remove(entity);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
