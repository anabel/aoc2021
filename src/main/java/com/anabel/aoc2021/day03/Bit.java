package com.anabel.aoc2021.day03;

public class Bit {
    public static Integer mostCommon(Integer onesTotal, Integer total) {
        return (onesTotal>total/2)?1:0;
    }

    public static Integer lessCommon(Integer onesTotal, Integer total) {
        return (onesTotal<total/2)?1:0;
    }
}
