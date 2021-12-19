package com.anabel.aoc2021.day05.part02;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public record Line(Position start, Position end) {

    public boolean isHorizontal(){
        return start.x() == end.x();
    }

    public boolean isVertical(){
        return start.y() == end.y();
    }

    public boolean isDiagonal() { return start.x() != end.x() && start.y() != end.y(); }

    public int max() {
        return IntStream.of(start.x(), start.y(), end.x(), end.y()).max().getAsInt();
    }

    @Override
    public String toString() {
        return "Line{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }

    public List<Position> toPositions() {
        if (isHorizontal()) {
            List<Integer> ys = Position.toPoints(start.y(), end.y());
            return ys.stream().map(y-> new Position(start.x(), y)).toList();
        } else if (isVertical()){
            List<Integer> xs = Position.toPoints(start.x(), end.x());
            return xs.stream().map(x-> new Position(x, start.y())).toList();
        } else if (isDiagonal()){
            List<Integer> xs = Position.toPoints(start.x(), end.x());
            List<Integer> ys = Position.toPoints(start.y(), end.y());
            return IntStream.range(0, xs.size()).mapToObj(i-> new Position(xs.get(i), ys.get(i))).toList();
        }
        return Collections.emptyList();
    }
}
