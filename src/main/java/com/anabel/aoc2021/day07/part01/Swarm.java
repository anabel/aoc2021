package com.anabel.aoc2021.day07.part01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Swarm {
    public final int max;
    public Integer[] costs;

    public Swarm(List<Integer> crabs) {
        max = crabs.stream().mapToInt(value -> value).max().orElseThrow(IllegalStateException::new);
        this.costs = new Integer[max];
        Arrays.fill(this.costs, 0);
        this.costs = crabs.stream().map(this::calculateCost).reduce(costs, this::sum);
    }

    public Integer[] calculateCost(int from) {
        return IntStream.range(0, max).mapToObj(to -> calculateCost(from, to)).toArray(Integer[]::new);
    }

    public int calculateCost(int from, int to) {
        return (from>to)?from-to:to-from;
    }

    public Integer[] sum(Integer[] total, Integer[] crab) {
        return IntStream.range(0, max).mapToObj(i-> total[i] + crab[i]).toArray(Integer[]::new);
    }

    public Integer alignCost() {
        return Arrays.stream(costs).mapToInt(value -> value).min().orElseThrow(IllegalStateException::new);
    }
}
