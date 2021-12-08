package com.anabel.aoc2021.day02.part01;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Dive01Test {

    @Test
    public void givengivenAStreamWithCommands_PositionIsCalculated() throws URISyntaxException, IOException {
        String expectedResult = "150";

        Path day02ExampleInput = Paths.get(getClass().getClassLoader()
                .getResource("day02ExampleInput.txt").toURI());

        Stream<String> commands = Files.lines(day02ExampleInput);
        String output = Dive01.solve(commands);
        commands.close();

        assertEquals(expectedResult, output);
    }
}