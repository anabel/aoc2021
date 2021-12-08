package com.anabel.aoc2021.day02.part02;

import com.anabel.aoc2021.day02.part02.command.Command;

public class Submarine {

    private Position position;

    public Submarine() {
        this.position = new Position(0,0,0);
    }

    public void apply(Command command) {
        this.position = command.moveFrom(position);
    }

    public Integer calculatePosition() {
        return position.horizontalPosition()*position.depth();
    }
}
