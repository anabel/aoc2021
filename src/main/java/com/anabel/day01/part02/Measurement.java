package com.anabel.day01.part02;

public class Measurement {
    private Integer value=0;

    public Measurement() {
    }

    public Measurement(Integer value) {
        this.value = value;
    }

    public boolean isLargerThan(Measurement previous) {
        return previous.value != null && value > previous.value;
    }

    public Measurement add(Measurement nextMeasurement) {
        Integer total = value + nextMeasurement.value;
        return new Measurement(total);
    }
}