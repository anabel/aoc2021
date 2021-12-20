package com.anabel.aoc2021.day06.part01;

import java.util.List;
import java.util.Optional;

public class School {
    private List<LanternFish> lanternFishes;

    public School(List<LanternFish> lanternFishes) {
        this.lanternFishes = lanternFishes;
    }
    public void daysPassed() {
        List<LanternFish> newLanternFishes = lanternFishes.stream()
                .map(LanternFish::dayPassed)
                .flatMap(Optional::stream)
                .toList();
        lanternFishes.addAll(newLanternFishes);
    }

    public int size() {
        return lanternFishes.size();
    }
}
