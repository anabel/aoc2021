package com.anabel.aoc2021.day08.part02;

import java.util.List;
import java.util.Objects;

public record Digit(List<Signal> signals) {

    public boolean isOne() {
        return signals.size() == 2;
    }

    public boolean isFour() {
        return signals.size() == 4;
    }

    public boolean isSeven() {
        return signals.size() == 3;
    }

    public boolean isEight() {
        return signals.size() == 7;
    }

    public boolean contains(Digit digit) {
        return signals.containsAll(digit.signals());
    }

    public boolean contains(Signal signal) {
        return signals.contains(signal);
    }

    public int size() {
        return signals.size();
    }

    public static Digit create(String value) {
        List<Signal> signals = value.chars()
                .mapToObj(i -> (char) i)
                .map(Signal::from)
                .toList();
        return new Digit(signals);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Digit digit = (Digit) o;
        return digit.contains(this) && this.contains(digit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(signals);
    }
}
