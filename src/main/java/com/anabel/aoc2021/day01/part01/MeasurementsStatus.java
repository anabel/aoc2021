package com.anabel.aoc2021.day01.part01;

public class MeasurementsStatus {
    private final Measurement measurement;
    private Integer counter = 0;

    public MeasurementsStatus() {
        measurement = new Measurement();
    }

    public MeasurementsStatus(Measurement measurement, Integer counter) {
        this.measurement = measurement;
        this.counter = counter;
    }

    public Integer getIncreasedCounter() {
        return counter;
    }

    public void incrementCounter() {
        counter++;
    }

    public MeasurementsStatus next(Measurement nextMeasure) {
        return new MeasurementsStatus(nextMeasure, this.counter);
    }

    public static MeasurementsStatus update(MeasurementsStatus previousStatus, MeasurementsStatus currentStatus) {
        if (currentStatus.measurement.isLargerThan(previousStatus.measurement)) {
            currentStatus.incrementCounter();
        }
        return currentStatus;
    }
}
