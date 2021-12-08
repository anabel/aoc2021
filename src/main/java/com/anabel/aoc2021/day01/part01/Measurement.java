package com.anabel.aoc2021.day01.part01;

public class Measurement {
    private Integer value;

    public Measurement() {
    }

    public Measurement(Integer value) {
        this.value = value;
    }

    public boolean isLargerThan(Measurement previous) {
        return previous.value != null && value > previous.value;
    }
}