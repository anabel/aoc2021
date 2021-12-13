package com.anabel.aoc2021.day04.Part01;

import com.anabel.aoc2021.day04.part01.GiantSquid01;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GiantSquid01Test {
    @Test
    void givenAListOfBinaryNumbers_SubmarineConsumptionIsCalculated() throws IOException, URISyntaxException {
        String expectedResult = "4512";

        Path day04ExampleInput = Paths.get(getClass().getClassLoader()
                .getResource("day04ExampleInput.txt").toURI());

        Stream<String> bingo = Files.lines(day04ExampleInput);
        String output = GiantSquid01.solve(bingo);
        bingo.close();

        assertEquals(expectedResult, output);
    }
}