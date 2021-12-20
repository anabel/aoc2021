package com.anabel.aoc2021.day07.part01;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TreacheryOfWhales01Test {
    @Test
    void givenAListOfCrabsHorizontalPositions_ThenFuelCostIsCalculated() throws IOException, URISyntaxException {
        String expectedResult = "37";

        Path day07ExampleInput = Paths.get(getClass().getClassLoader()
                .getResource("day07ExampleInput.txt").toURI());

        Stream<String> crabPositions = Files.lines(day07ExampleInput);
        String output = TreacheryOfWhales01.solve(crabPositions);
        crabPositions.close();

        assertEquals(expectedResult, output);
    }
}
