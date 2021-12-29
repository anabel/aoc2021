package com.anabel.aoc2021.day08.part01;

import com.anabel.aoc2021.day08.part02.SevenSegmentSearch02;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SevenSegmentSearch01Test {
    @Test
    void givenAListOfDisplayPatternsAndOutputs_ThenNumber1478AppearancesIsCalculated() throws IOException, URISyntaxException {
        String expectedResult = "26";

        Path day08ExampleInput = Paths.get(getClass().getClassLoader()
                .getResource("day08ExampleInput.txt").toURI());

        Stream<String> entries = Files.lines(day08ExampleInput);
        String output = SevenSegmentSearch02.solve(entries);
        entries.close();

        assertEquals(expectedResult, output);
    }
}
