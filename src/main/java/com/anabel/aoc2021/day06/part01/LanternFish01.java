package com.anabel.aoc2021.day06.part01;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LanternFish01 {
    public static int DAYS = 80;
    public static String solve(Stream<String> lanternFishAges) {
        List<LanternFish> lanternFishes = lanternFishAges.map(ages -> ages.split(","))
                .flatMap(Stream::of)
                .mapToInt(Integer::valueOf)
                .mapToObj(LanternFish::new).collect(Collectors.toList());
        School school = new School(lanternFishes);
        IntStream.range(0, DAYS).forEach(day -> school.daysPassed());
        return String.valueOf(school.size());
    }
}
