package com.anabel.aoc2021.day05.part02;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public record Position(int x, int y) {
    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public static List<Integer> toPoints(int start, int end) {
        if (start < end) {
            return IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());
        } else {
            List<Integer> points = IntStream.rangeClosed(end, start).boxed().collect(Collectors.toList());
            Collections.reverse(points);
            return points;
        }
    }

}
