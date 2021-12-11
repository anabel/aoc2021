package com.anabel.aoc2021.day03.part01;

public class Bit {
    public static Integer mostCommon(Integer onesTotal, Integer total) {
        Integer zerosTotal = total - onesTotal;
        return (onesTotal>=zerosTotal)?1:0;
    }

    public static Integer lessCommon(Integer onesTotal, Integer total) {
        Integer zerosTotal = total - onesTotal;
        return (onesTotal<zerosTotal)?1:0;
    }
}
