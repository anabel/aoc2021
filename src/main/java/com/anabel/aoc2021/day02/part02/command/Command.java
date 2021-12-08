package com.anabel.aoc2021.day02.part02.command;

import com.anabel.aoc2021.day02.part02.Position;

public class Command {
    Integer units;
    CommandType commandType;

    public Command(CommandType commandType, Integer units) {
        this.commandType = commandType;
        this.units = units;
    }

    public Position moveFrom(Position position) {
        return commandType.moveFrom(position, units);
    }
}
