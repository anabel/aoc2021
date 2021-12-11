package com.anabel.aoc2021.day03.part02;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public record Rate(Integer[] bits) {

    public Integer get(int i) {
        if (i > bits.length) {
            throw new IllegalArgumentException();
        }
        return bits[i];
    }

    public BinaryNumber toBinaryNumber() {
        String number = Stream.of(this.bits).map(String::valueOf).collect(Collectors.joining());
        return new BinaryNumber(number);
    }

    @Override
    public String toString() {
        return "Rate{" +
                "bits=" + Arrays.toString(bits) +
                '}';
    }
}
