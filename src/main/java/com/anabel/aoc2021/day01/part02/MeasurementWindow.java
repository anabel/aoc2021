package com.anabel.aoc2021.day01.part02;

import java.util.LinkedList;

public class MeasurementWindow {
    private final LinkedList<Measurement> measurements;
    public static final Integer DEFAULT_WINDOW = 3;

    public MeasurementWindow() {
        measurements = new LinkedList<>();
    }

    public MeasurementWindow(LinkedList<Measurement> measurements) {
        this.measurements = measurements;
    }

    public Measurement sum() {
       return measurements.stream()
               .reduce(new Measurement(), Measurement::add);
    }

    public boolean isLargerThan(MeasurementWindow previous) {
        return this.sum().isLargerThan(previous.sum());
    }

    public MeasurementWindow add(Measurement nextMeasure) {
        LinkedList<Measurement> nextMeasurements = (LinkedList<Measurement>) measurements.clone();
        nextMeasurements.addLast(nextMeasure);
        if(nextMeasurements.size() > DEFAULT_WINDOW) {
            nextMeasurements.removeFirst();
        }
        return new MeasurementWindow(nextMeasurements);
    }

    public boolean isUseful() {
        return measurements.size() == DEFAULT_WINDOW;
    }
}
