package com.anabel.aoc2021.day08.part02;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DisplayAdapter {
    private DisplayAdapter() {}

    public static Display from(String entry) {
        String[] input = entry.split("\\|");
        if (input.length != 2) {
            throw new IllegalArgumentException();
        }
        List<Digit> patterns = stream(input[0]).collect(Collectors.toList());
        Digit[] output = stream(input[1]).toArray(Digit[]::new);
        return new Display.DisplayBuilder()
                .with(patterns)
                .with(output)
                .build();
    }

    private static Stream<Digit> stream(String input) {
        return Arrays.stream(input.split("\\s+"))
                .filter(digit -> digit.trim().length() > 0)
                .map(Digit::create);
    }
}
