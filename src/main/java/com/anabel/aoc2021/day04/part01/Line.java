package com.anabel.aoc2021.day04.part01;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;

public record Line(Number[] numbers) {
    public static Line from(String numbersString) {
        Number[] numbers = Arrays.stream(numbersString.split("\s+")).filter(Predicate.not(String::isBlank))
                .mapToInt(Integer::valueOf)
                .mapToObj(Number::new)
                .toArray(Number[]::new);
        return new Line(numbers);
    }

    @Override
    public String toString() {
        return "Line{" +
                "numbers=" + Arrays.toString(numbers) +
                '}';
    }

    public void numberDrawn(Integer number) {
        Arrays.stream(numbers)
                .filter(n -> n.is(number))
                .forEach(Number::mark);
    }

    public boolean isMarked() {
        return Arrays.stream(numbers).allMatch(Number::isMarked);
    }

    public Integer sum(Predicate<Number> marked) {
        return Stream.of(numbers).filter(marked).mapToInt(Number::getValue).sum();
    }
}
