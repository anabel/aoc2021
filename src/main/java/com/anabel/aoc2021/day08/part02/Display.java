package com.anabel.aoc2021.day08.part02;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Display {
    private Digit[] output;
    private Digit[] digits;

    public Display(Digit[] digits, Digit[] output) {
        this.digits = digits;
        this.output = output;
    }

    public Long decode() {
        String number = Arrays.stream(output)
                .map(this::decode)
                .collect(Collectors.joining());
        return Long.valueOf(number);
    }

    public String decode(Digit digit) {
        Integer value = IntStream.rangeClosed(0,9)
                .filter(i-> digit.equals(digits[i]))
                .reduce((a, b) -> { throw new IllegalStateException(); } )
                .orElseThrow(IllegalStateException::new);
        return String.valueOf(value);
    }

    public static class DisplayBuilder {
        private List<Digit> patterns;
        private Digit[] output;

        public DisplayBuilder() {}

        public DisplayBuilder with(List<Digit> patterns) {
            this.patterns = patterns;
            return this;
        }

        public DisplayBuilder with(Digit[] output) {
            this.output = output;
            return this;
        }

        public Display build() {
            Digit[] digits = new DigitsBuilder().with(patterns).infer();
            return new Display(digits, output);
        }
    }
}
