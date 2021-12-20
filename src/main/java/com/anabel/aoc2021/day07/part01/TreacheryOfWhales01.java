package com.anabel.aoc2021.day07.part01;

import java.util.List;
import java.util.stream.Stream;

public class TreacheryOfWhales01 {
    public static String solve(Stream<String> crabPositions) {
        List<Integer> crabs = crabPositions.map(positions -> positions.split(","))
                .flatMap(Stream::of)
                .mapToInt(Integer::valueOf)
                .boxed()
                .toList();
        Swarm swarm = new Swarm(crabs);
        return String.valueOf(swarm.alignCost());
    }
}
