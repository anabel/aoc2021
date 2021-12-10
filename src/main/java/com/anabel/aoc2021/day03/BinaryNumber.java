package com.anabel.aoc2021.day03;

public record BinaryNumber(String number) {
    public static Integer LENGTH;

    public Integer toDecimal() {
        return Integer.parseInt(number, 2);
    }

    public static void setLength(Integer LENGTH) {
        BinaryNumber.LENGTH = LENGTH;
    }
}
