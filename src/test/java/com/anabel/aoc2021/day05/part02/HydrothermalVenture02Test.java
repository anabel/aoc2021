package com.anabel.aoc2021.day05.part02;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class HydrothermalVenture02Test {
    @Test
    void givenAListOfVentLines_ThenNumberOfPointsWhereLinesOverlapIsCalculated() throws IOException, URISyntaxException {
        String expectedResult = "12";

        Path day05ExampleInput = Paths.get(getClass().getClassLoader()
                .getResource("day05ExampleInput.txt").toURI());

        Stream<String> vents = Files.lines(day05ExampleInput);
        String output = HydrothermalVenture02.solve(vents);
        vents.close();

        assertEquals(expectedResult, output);
    }

}