package com.anabel.day01.part02;

public class MeasurementsStatus {
    private MeasurementWindow measurementWindow;
    private Integer counter = 0;

    public MeasurementsStatus() {
        measurementWindow = new MeasurementWindow();
    }

    public MeasurementsStatus(MeasurementWindow measurementWindow, Integer counter) {
        this.measurementWindow = measurementWindow;
        this.counter = counter;
    }

    public Integer getIncreasedCounter() {
        return counter;
    }

    public void incrementCounter() {
        counter++;
    }

    public MeasurementsStatus next(Measurement nextMeasure) {
        MeasurementWindow nextMeasurementWindow = measurementWindow.add(nextMeasure);
        return new MeasurementsStatus(nextMeasurementWindow, this.counter);
    }

    public boolean isUpdateable() {
        return measurementWindow.isUseful();
    }

    public static MeasurementsStatus update(MeasurementsStatus previousStatus, MeasurementsStatus currentStatus) {
        if (previousStatus.isUpdateable() && currentStatus.measurementWindow.isLargerThan(previousStatus.measurementWindow)) {
            currentStatus.incrementCounter();
        }
        return currentStatus;
    }
}
