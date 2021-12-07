package com.anabel.day01.part01;

import com.anabel.day01.part01.DepthIncreaseCounter;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Day01Test {

    @Test
    public void givenAFileWithMeasurements_NumberOfIncreasesIsCalculated() throws URISyntaxException, IOException {
        int expectedNumberOfIncreases = 7;

        Path day01ExampleInput = Paths.get(getClass().getClassLoader()
                .getResource("day01ExampleInput.txt").toURI());

        Stream<String> measurements = Files.lines(day01ExampleInput);
        DepthIncreaseCounter totalCounter = measurements.map(Integer::parseInt)
                .reduce(new DepthIncreaseCounter(),
                        (counter, measurement) ->
                                DepthIncreaseCounter.count(counter,
                                        counter.create(measurement)),
                        DepthIncreaseCounter::count);
        measurements.close();

        assertEquals(expectedNumberOfIncreases, totalCounter.getCounter());
    }

}