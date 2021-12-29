package com.anabel.aoc2021.day08.part02;

import java.util.Arrays;

public enum Signal {
    A('a'),
    B('b'),
    C('c'),
    D('d'),
    E('e'),
    F('f'),
    G('g');

    private final char value;

    Signal(char value) {
        this.value = value;
    }

    public static Signal from(char value) {
        return Arrays.stream(Signal.values())
                .filter(signal -> signal.value == value)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
