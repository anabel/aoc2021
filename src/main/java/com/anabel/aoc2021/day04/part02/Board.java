package com.anabel.aoc2021.day04.part02;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public record Board(List<Line> lines) {
    public static int DEFAULT_SIZE = 5;

    @Override
    public String toString() {
        return "Board{" +
                "lines=" + lines +
                '}';
    }

    public void numberDrawn(Integer number) {
        lines.forEach(l -> l.numberDrawn(number));
    }

    public boolean hasWon() {
        return this.hasLine() || this.hasColumn();
    }

    public boolean hasColumn() {
        return this.transpose().hasLine();
    }

    public boolean hasLine() {
        return lines.stream().map(Line::isMarked).reduce(Boolean.FALSE, Boolean::logicalOr);
    }

    public Board transpose() {
        return new Board(transposeLines());
    }

    private List<Line> transposeLines() {
        Number[][] newLines = new Number[5][5];
        IntStream.range(0, 5).forEach(j ->
                IntStream.range(0, 5).forEach(i ->
                        newLines[i][j] = this.lines.get(j).numbers()[i]
                ));
        return Arrays.stream(newLines).map(Line::new).collect(Collectors.toList());
    }

    public Integer calculateScore(Integer winningNumber) {
        if (!hasWon()) {
            throw new IllegalStateException();
        }
        Integer notMarkedSum = lines.stream()
                .mapToInt(l -> l.sum(Predicate.not(Number::isMarked)))
                .sum();
        return notMarkedSum * winningNumber;
    }
}
