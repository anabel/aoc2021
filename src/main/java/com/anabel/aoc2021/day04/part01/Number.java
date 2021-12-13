package com.anabel.aoc2021.day04.part01;

import java.util.Objects;

public class Number {
    private final Integer value;
    private Boolean marked = false;

    public Number(Integer value) {
        this.value = value;
    }

    public boolean is(Integer number) {
        return value.equals(number);
    }

    public Integer getValue() {
        return value;
    }

    public Boolean isMarked() {
        return marked != null && marked;
    }

    public void mark() {
        this.marked = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return value.equals(number.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.format("%s %s", value,marked?"v":" ");
    }
}
