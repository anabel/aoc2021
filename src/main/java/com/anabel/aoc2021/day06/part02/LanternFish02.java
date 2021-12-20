package com.anabel.aoc2021.day06.part02;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LanternFish02 {
    public static int DAYS = 256;
    public static String solve(Stream<String> lanternFishAges) {
        List<Integer> lanternFishes = lanternFishAges.map(ages -> ages.split(","))
                .flatMap(Stream::of)
                .mapToInt(Integer::valueOf).boxed().toList();
        School school = new School(lanternFishes);
        IntStream.range(0, DAYS).forEach(day -> school.dayPassed());
        return String.valueOf(school.size());
    }
}
