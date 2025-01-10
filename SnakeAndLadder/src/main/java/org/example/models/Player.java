package org.example.models;

public class Player {
    String name;
    Cell position;

    public Player(String name, Cell cell) {
        this.name=name;
        this.position=cell;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cell getCell() {
        return position;
    }

    public void setPosition(Cell position) {
        this.position = position;
    }
}
