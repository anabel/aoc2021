package com.anabel.aoc2021.day02.part02;

import com.anabel.aoc2021.day02.part02.command.Command;

public record Position(Integer horizontalPosition,
                       Integer depth, Integer aim) {

    public Position apply(Command command, Position position) {
        return command.moveFrom(position);
    }
}
