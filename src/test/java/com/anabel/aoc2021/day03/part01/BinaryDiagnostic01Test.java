package com.anabel.aoc2021.day03.part01;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BinaryDiagnostic02Test {
    @Test
    void givenAListOfBinaryNumbers_LifeSupportRatingIsCalculated() throws IOException, URISyntaxException {
        String expectedResult = "230";

        Path day03ExampleInput = Paths.get(getClass().getClassLoader()
                .getResource("day03ExampleInput.txt").toURI());

        Stream<String> report = Files.lines(day03ExampleInput);
        String output = BinaryDiagnostic01.solve(report);
        report.close();

        assertEquals(expectedResult, output);
    }
}