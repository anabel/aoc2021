package com.anabel.aoc2021.day02.part01;

import com.anabel.aoc2021.day02.part01.command.CommandAdapter;

import java.util.Optional;
import java.util.stream.Stream;

public class Dive01 {
    public static String solve(Stream<String> commands) {
        Submarine submarine = new Submarine();
        commands.map(CommandAdapter::toCommand)
                .flatMap(Optional::stream)
                .forEach(c -> submarine.apply(c));

        return String.valueOf(submarine.calculatePosition());
    }
}
