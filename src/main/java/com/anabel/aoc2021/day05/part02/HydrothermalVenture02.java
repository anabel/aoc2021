package com.anabel.aoc2021.day05.part02;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class HydrothermalVenture02 {
    public static String solve(Stream<String> vents) {
        List<Line> lines = vents.map(LineAdapter::from).toList();
        Diagram diagram = new Diagram(lines);
        return String.valueOf(diagram.dangerousPointsCount());
    }
}
