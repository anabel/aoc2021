package com.anabel.aoc2021.day08.part01;

import java.util.List;
import java.util.stream.Stream;

public class SevenSegmentSearch01 {
    public static String solve(Stream<String> entries) {
        List<Output> outputs = entries.map(entry -> entry.substring(entry.indexOf("|")))
                .map(OutputAdapter::from)
                .toList();
        return String.valueOf(outputs.stream()
                .mapToLong(Output::sum)
                .sum());
    }
}
