package com.anabel.aoc2021.day02.part01;

import com.anabel.aoc2021.day02.part01.command.Command;

public record Position(Integer horizontalPosition,
                       Integer depth) {

    public Position apply(Command command, Position position) {
        return command.moveFrom(position);
    }
}
