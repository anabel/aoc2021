package com.anabel.aoc2021.day06.part01;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LanternFish01Test {
    @Test
    void givenAListOfNearbyLanternFish_ThenNumberOfLanternFishIn80DaysIsCalculated() throws IOException, URISyntaxException {
        String expectedResult = "5934";

        Path day06ExampleInput = Paths.get(getClass().getClassLoader()
                .getResource("day06ExampleInput.txt").toURI());

        Stream<String> lanternFishAges = Files.lines(day06ExampleInput);
        String output = LanternFish01.solve(lanternFishAges);
        lanternFishAges.close();

        assertEquals(expectedResult, output);
    }

}