package com.anabel.aoc2021.day02.part01.command;

import com.anabel.aoc2021.day02.part01.Position;

import java.util.Arrays;

public enum CommandType {
    FORWARD("forward") {
        @Override
        public Position moveFrom(Position position, Integer units) {
            return new Position(position.horizontalPosition() + units, position.depth());
        }
    },
    UP("up") {
        @Override
        public Position moveFrom(Position position, Integer units) {
            return new Position(position.horizontalPosition(), position.depth() - units);
        }
    },
    DOWN("down") {
        @Override
        public Position moveFrom(Position position, Integer units) {
            return new Position(position.horizontalPosition(), position.depth() + units);
        }
    };

    private String alias;

    CommandType(String alias) {
        this.alias = alias;
    }

    public abstract Position moveFrom(Position position, Integer units);

    public static CommandType from(String alias) {
        return Arrays.stream(CommandType.values())
                .filter(ct -> ct.alias.equals(alias))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
}
