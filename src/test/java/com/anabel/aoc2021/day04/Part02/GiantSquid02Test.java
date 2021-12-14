package com.anabel.aoc2021.day04.Part02;

import com.anabel.aoc2021.day04.part02.GiantSquid02;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GiantSquid02Test {
    @Test
    void givenNumbersAndBoards_WhenLastBoardWinsScoreIsCalculated() throws IOException, URISyntaxException {
        String expectedResult = "1924";

        Path day04ExampleInput = Paths.get(getClass().getClassLoader()
                .getResource("day04ExampleInput.txt").toURI());

        Stream<String> bingo = Files.lines(day04ExampleInput);
        String output = GiantSquid02.solve(bingo);
        bingo.close();

        assertEquals(expectedResult, output);
    }
}