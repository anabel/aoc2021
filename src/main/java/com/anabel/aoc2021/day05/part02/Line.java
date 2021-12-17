package com.anabel.aoc2021.day05.part02;

import java.util.stream.IntStream;

public record Line(Position start, Position end) {

    public boolean isHorizontal(){
        return start.x() == end.x();
    }

    public boolean isVertical(){
        return start.y() == end.y();
    }

    public static Line create(Position first, Position second) {
        if (first.isSmallerThan(second)) {
            return new Line(first, second);
        } else {
            return new Line(second, first);
        }
    }

    public int max() {
        return IntStream.of(start.x(), start().y(), end().x(), end.y()).max().getAsInt();
    }

    @Override
    public String toString() {
        return "Line{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
