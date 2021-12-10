package com.anabel.aoc2021.day03;

import com.anabel.aoc2021.day02.part02.Dive02;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BinaryDiagnostic01Test {
    @Test
    void givenAListOfBinaryNumbers_SubmarineConsumptionIsCalculated() throws IOException, URISyntaxException {
        String expectedResult = "198";

        Path day03ExampleInput = Paths.get(getClass().getClassLoader()
                .getResource("day03ExampleInput.txt").toURI());

        Stream<String> report = Files.lines(day03ExampleInput);
        String output = BinaryDiagnostic01.solve(report);
        report.close();

        assertEquals(expectedResult, output);
    }
}