package com.anabel.aoc2021.day05.part01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Diagram {
    private int[][] values;

    public Diagram(List<Line> lines) {
        int maxCoordinate = lines.stream().mapToInt(Line::max).max().orElseThrow(IllegalStateException::new);
        initialize(maxCoordinate+1);
        lines.forEach(this::addLine);
    }

    private void initialize(int size){
        this.values = new int[size][size];
        IntStream.range(0, size).forEach(i -> Arrays.fill(values[i], 0));
    }

    private void addLine(Line line) {
        if (line.isHorizontal()) {
            IntStream.rangeClosed(line.start().y(),line.end().y()).forEach(y -> {
                addLineToPoint(y, line.start().x());
            });
        } else {
            IntStream.rangeClosed(line.start().x(),line.end().x()).forEach(x -> {
                addLineToPoint(line.start().y(), x);
            });
        }
    }

    private void addLineToPoint(int i, int j) {
        this.values[i][j]++;
    }

    public Integer dangerousPointsCount() {
        return IntStream.range(0,values.length)
                .reduce(0, (count, i) ->
                        count+=IntStream.range(0, values[i].length)
                                .filter(j -> values[i][j] >= 2)
                                .count());
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        IntStream.range(0,values.length).forEach(i -> {
            IntStream.range(0,values[i].length).forEach(j -> {
                stringBuilder.append(values[i][j]);
            });
            stringBuilder.append("\n");
        });
        return stringBuilder.toString();
    }
}
