package com.anabel.aoc2021.day08.part01;

public class OutputAdapter {
    private OutputAdapter() {}

    public static Output from(String entry) {
        String[] digits = entry.split("\\s+");
        return new Output(digits);
    }
}
