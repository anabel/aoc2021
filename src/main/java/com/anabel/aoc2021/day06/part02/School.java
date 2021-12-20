package com.anabel.aoc2021.day06.part02;

import java.util.Arrays;
import java.util.List;

public class School {
    private long[] lanternFishes = new long[NEW_AGE+1];
    public static int DEFAULT_AGE = 6;
    public static int NEW_AGE = 8;

    public School(List<Integer> lanternFishAges) {
        Arrays.fill(lanternFishes, 0);
        lanternFishAges.forEach(age -> this.lanternFishes[age]++);
    }

    public void dayPassed() {
        long spawnedLanternFishes = lanternFishes[0];
        for(int age=0; age < NEW_AGE; age++) {
            lanternFishes[age] = lanternFishes[age+1];
            if (age == DEFAULT_AGE) {
                lanternFishes[age] += spawnedLanternFishes;
            }
        }
        lanternFishes[8] = spawnedLanternFishes;
    }

    public long size() {
        return Arrays.stream(lanternFishes).sum();
    }
}
