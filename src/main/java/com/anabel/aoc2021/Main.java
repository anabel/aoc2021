package com.anabel.aoc2021;

import com.anabel.aoc2021.day01.part01.SonarSweep01;
import com.anabel.aoc2021.day01.part02.SonarSweep02;
import com.anabel.aoc2021.day02.part01.Dive01;
import com.anabel.aoc2021.day02.part02.Dive02;
import com.anabel.aoc2021.day03.part01.BinaryDiagnostic01;
import com.anabel.aoc2021.day03.part02.BinaryDiagnostic02;
import com.anabel.aoc2021.day04.part01.GiantSquid01;
import com.anabel.aoc2021.day04.part02.GiantSquid02;
import com.anabel.aoc2021.day05.part01.HydrothermalVenture01;
import com.anabel.aoc2021.day05.part02.HydrothermalVenture02;
import com.anabel.aoc2021.day06.part01.LanternFish01;
import com.anabel.aoc2021.day06.part02.LanternFish02;
import com.anabel.aoc2021.day07.part01.TreacheryOfWhales01;
import com.anabel.aoc2021.day07.part02.TreacheryOfWhales02;
import com.anabel.aoc2021.day08.part01.SevenSegmentSearch01;
import com.anabel.aoc2021.day08.part02.SevenSegmentSearch02;
import com.anabel.aoc2021.shared.Solver;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        Stream<Solver> solvers = Stream.of(
                new Solver("Day 01 Part 01", "day01Input.txt", SonarSweep01::solve),
                new Solver("Day 01 Part 02", "day01Input.txt", SonarSweep02::solve),
                new Solver("Day 02 Part 01", "day02Input.txt", Dive01::solve),
                new Solver("Day 02 Part 02", "day02Input.txt", Dive02::solve),
                new Solver("Day 03 Part 01", "day03Input.txt", BinaryDiagnostic01::solve),
                new Solver("Day 03 Part 02", "day03Input.txt", BinaryDiagnostic02::solve),
                new Solver("Day 04 Part 01", "day04Input.txt", GiantSquid01::solve),
                new Solver("Day 04 Part 02", "day04Input.txt", GiantSquid02::solve),
                new Solver("Day 05 Part 01", "day05Input.txt", HydrothermalVenture01::solve),
                new Solver("Day 05 Part 02", "day05Input.txt", HydrothermalVenture02::solve),
                new Solver("Day 06 Part 01", "day06Input.txt", LanternFish01::solve),
                new Solver("Day 06 Part 02", "day06Input.txt", LanternFish02::solve),
                new Solver("Day 07 Part 01", "day07Input.txt", TreacheryOfWhales01::solve),
                new Solver("Day 07 Part 02", "day07Input.txt", TreacheryOfWhales02::solve),
                new Solver("Day 08 Part 01", "day08Input.txt", SevenSegmentSearch01::solve),
                new Solver("Day 08 Part 02", "day08Input.txt", SevenSegmentSearch02::solve)
        );


        System.out.println("--- Advent of Code 2021 ---");
        solvers.map(solver ->
                        String.format("- %s: %s", solver.getName(), solver.execute().orElse("Execution Error")))
                .forEach(System.out::println);

    }
}

