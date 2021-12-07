package com.anabel.day01.part01;

public class DepthIncreaseCounter {
    private Integer counter = 0;
    private Integer measurement;

    public DepthIncreaseCounter() {
    }

    public DepthIncreaseCounter(Integer measurement, Integer counter) {
        this.measurement = measurement;
        this.counter = counter;
    }

    public Integer getCounter() {
        return counter;
    }

    public boolean depthHasIncreased(Integer newMeasurement) {
        return measurement != null && measurement < newMeasurement;
    }

    public void increaseCounter() {
        counter++;
    }

    public DepthIncreaseCounter create(Integer nextMeasure) {
        return new DepthIncreaseCounter(nextMeasure, this.counter);
    }

    public static DepthIncreaseCounter count(DepthIncreaseCounter previousCounter, DepthIncreaseCounter nextCounter) {
        if (previousCounter.depthHasIncreased(nextCounter.measurement)) {
            nextCounter.increaseCounter();
        }
        return nextCounter;
    }
}
