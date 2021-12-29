package com.anabel.aoc2021.day08.part01;

import java.util.Arrays;
import java.util.function.Predicate;

public record Output(String[] digits) {

    public long ones() {
        return count(digit -> digit.length() == 2);
    }

    public long fours() {
        return count(digit -> digit.length() == 4);
    }

    public long sevens() {
        return count(digit -> digit.length() == 3);
    }

    public long eights() {
        return count(digit -> digit.length() == 7);
    }

    public long count(Predicate<String> condition) {
        return Arrays.stream(digits).filter(condition).count();
    }

    public long sum() {
        return ones() + fours() + sevens() + eights();
    }
}
