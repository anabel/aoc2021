package com.anabel.aoc2021.day05.part02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LineAdapter {

    public static Line from(String coordinates) {
        String regex = "(?<firstX>\\d+),(?<firstY>\\d+) -> (?<secondX>\\d+),(?<secondY>\\d+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(coordinates);
        if (!matcher.find()) {
            throw new IllegalArgumentException();
        }
        int firstX = Integer.parseInt(matcher.group("firstX"));
        int firstY = Integer.parseInt(matcher.group("firstY"));
        int secondX = Integer.parseInt(matcher.group("secondX"));
        int secondY = Integer.parseInt(matcher.group("secondY"));
        Position first = new Position(firstX, firstY);
        Position second = new Position(secondX, secondY);
        return new Line(first, second);
    }
}
