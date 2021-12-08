package com.anabel.aoc2021.day01.part01;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SonarSweep01Test {

    @Test
    public void givenAFileWithMeasurements_NumberOfIncreasesIsCalculated() throws URISyntaxException, IOException {
        String expectedResult = "7";

        Path day01ExampleInput = Paths.get(getClass().getClassLoader()
                .getResource("day01ExampleInput.txt").toURI());

        Stream<String> measurements = Files.lines(day01ExampleInput);
        String output = SonarSweep01.solve(measurements);
        measurements.close();

        assertEquals(expectedResult, output);
    }

}