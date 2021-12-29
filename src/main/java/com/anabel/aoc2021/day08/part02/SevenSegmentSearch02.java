package com.anabel.aoc2021.day08.part02;

import java.util.List;
import java.util.stream.Stream;

public class SevenSegmentSearch02 {
    public static String solve(Stream<String> entries) {
        List<Display> displays = entries
                .map(DisplayAdapter::from)
                .toList();

        return String.valueOf(displays.stream()
                .mapToLong(Display::decode)
                .sum());
    }
}
