package com.anabel.aoc2021.day08.part02;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class DigitsBuilder {
    private List<Digit> patterns;

    public DigitsBuilder() {}

    public DigitsBuilder with(List<Digit> patterns) {
        this.patterns = patterns;
        return this;
    }

    public Digit[] infer() {
        if (patterns == null || patterns.isEmpty()) {
            throw new IllegalStateException();
        }
        Digit[] digits = new Digit[10];
        digits[1] = findOne(Digit::isOne);
        patterns.remove(digits[1]);
        digits[4] = findOne(Digit::isFour);
        patterns.remove(digits[4]);
        digits[7] = findOne(Digit::isSeven);
        patterns.remove(digits[7]);
        digits[8] = findOne(Digit::isEight);
        patterns.remove(digits[8]);
        digits[9] = findOne(
                filter(digit -> digit.size() == 6)
                        .filter(digit -> digit.contains(digits[4])));
        patterns.remove(digits[9]);
        digits[6] = findOne(
                filter(digit -> digit.size() == 6)
                        .filter(digit -> !digit.contains(digits[7])));
        patterns.remove(digits[6]);
        digits[0] = findOne(
                filter(digit -> digit.signals().size() == 6));
        patterns.remove(digits[0]);
        digits[3] = findOne(
                filter(digit -> digit.size() == 5)
                        .filter(digit -> digit.contains(digits[7])));
        patterns.remove(digits[3]);
        Signal c = digits[8].signals().stream().filter(signal -> !digits[6].contains(signal))
                .reduce((a, b) -> { throw new IllegalArgumentException(); } )
                .orElseThrow();
        digits[2] = findOne(
                filter(digit -> digit.size() == 5)
                        .filter(digit -> digit.contains(c)));
        patterns.remove(digits[2]);
        digits[5] = findOne(
                filter(digit -> digit.size() == 5));
        patterns.remove(digits[5]);
        return digits;
    }

    private Digit findOne(Predicate<Digit> condition) {
        return findOne(filter(condition));
    }

    private Digit findOne(Stream<Digit> stream) {
        return stream.reduce((a, b) -> { throw new IllegalStateException(); } )
                .orElseThrow();
    }

    private Stream<Digit> filter(Predicate<Digit> condition) {
        return patterns.stream()
                .filter(condition);
    }
}
