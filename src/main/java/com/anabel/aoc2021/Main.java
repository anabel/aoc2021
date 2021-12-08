package com.anabel.aoc2021;

import com.anabel.aoc2021.day01.part01.SonarSweep01;
import com.anabel.aoc2021.day01.part02.SonarSweep02;
import com.anabel.aoc2021.day02.part01.Dive;
import com.anabel.aoc2021.shared.Solver;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        Stream<Solver> solvers = Stream.of(
                new Solver("Day 01 Part 01", "day01Input.txt", SonarSweep01::solve),
                new Solver("Day 01 Part 02", "day01Input.txt", SonarSweep02::solve),
                new Solver("Day 02 Part 01", "day02Input.txt", Dive::solve)
        );


        System.out.println("--- Advent of Code 2021 ---");
        solvers.map(solver ->
                        String.format("- %s: %s", solver.getName(), solver.execute().orElse("Execution Error")))
                .forEach(System.out::println);

    }
}

