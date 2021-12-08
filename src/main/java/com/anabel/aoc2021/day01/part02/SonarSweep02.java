package com.anabel.aoc2021.day01.part02;

import java.util.stream.Stream;

public class SonarSweep02 {
    public static String solve(Stream<String> measurements) {
        MeasurementsStatus finalStatus = measurements
                .map(Integer::parseInt)
                .map(Measurement::new)
                .reduce(new MeasurementsStatus(),
                        (currentStatus, nextMeasurement) ->
                                MeasurementsStatus.update(currentStatus,
                                        currentStatus.next(nextMeasurement)),
                        MeasurementsStatus::update);
        return String.valueOf(finalStatus.getIncreasedCounter());
    }
}
