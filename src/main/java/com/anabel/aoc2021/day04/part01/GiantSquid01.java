package com.anabel.aoc2021.day04.part01;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class GiantSquid01 {
    public static String solve(Stream<String> input) {
        List<String> bingoInput = input.filter(Predicate.not(String::isBlank)).toList();
        Iterator<Integer> numbers = parseNumbers(bingoInput);
        Bingo bingo = new Bingo(parseBoards(bingoInput));
        Integer number;
        do {
            number = numbers.next();
            bingo.drawNumber(number);
        } while(numbers.hasNext() && bingo.thereIsNoWinnerBoard());
        return String.valueOf(bingo.getScore(number));
    }

    private static Iterator<Integer> parseNumbers(List<String> bingo) {
        return Arrays.stream(bingo.get(0).split(","))
                .mapToInt(Integer::valueOf)
                .boxed().iterator();
    }

    private static List<Board> parseBoards(List<String> bingo) {
        AtomicInteger index = new AtomicInteger();
        return bingo.stream().skip(1).map(Line::from)
                .collect(groupingBy(l -> index.getAndIncrement() / Board.DEFAULT_SIZE))
                .values()
                .stream()
                .map(Board::new)
                .toList();
    }
}
