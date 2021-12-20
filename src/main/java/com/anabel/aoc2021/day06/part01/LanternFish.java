package com.anabel.aoc2021.day06.part01;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class LanternFish {
    public static int DEFAULT_AGE = 6;
    public static int FIRST_CYCLE_INCREMENT = 2;
    private final AtomicInteger internalTimer;

    public LanternFish(int age) {
        internalTimer = new AtomicInteger(age);
    }

    public Optional<LanternFish> dayPassed() {
        if (internalTimer.compareAndSet(0, DEFAULT_AGE)) {
            return Optional.of(LanternFish.create());
        } else {
            internalTimer.decrementAndGet();
            return Optional.empty();
        }
    }

    public static LanternFish create() {
        return new LanternFish(DEFAULT_AGE+ FIRST_CYCLE_INCREMENT);
    }


}
