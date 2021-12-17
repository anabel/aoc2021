package com.anabel.aoc2021.day05.part01;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class HydrothermalVenture01 {
    public static String solve(Stream<String> vents) {
        Predicate<Line> isHorizontal = Line::isHorizontal;
        Predicate<Line> isVertical = Line::isVertical;
        List<Line> lines = vents.map(LineAdapter::from).filter(isHorizontal.or(isVertical)).toList();
        Diagram diagram = new Diagram(lines);
        return String.valueOf(diagram.dangerousPointsCount());
    }
}
