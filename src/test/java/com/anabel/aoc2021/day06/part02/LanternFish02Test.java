package com.anabel.aoc2021.day06.part02;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LanternFish02Test {
    @Test
    void givenAListOfNearbyLanternFish_ThenNumberOfLanternFishIn80DaysIsCalculated() throws IOException, URISyntaxException {
        String expectedResult = "26984457539";

        Path day06ExampleInput = Paths.get(getClass().getClassLoader()
                .getResource("day06ExampleInput.txt").toURI());

        Stream<String> lanternFishAges = Files.lines(day06ExampleInput);
        String output = LanternFish02.solve(lanternFishAges);
        lanternFishAges.close();

        assertEquals(expectedResult, output);
    }

}