package com.anabel.aoc2021.day04.part02;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Bingo {
    List<Board> boards;

    public Bingo(List<Board> boards) {
        this.boards = boards;
    }

    public void drawNumber(Integer number) {
        boards.forEach(b -> b.numberDrawn(number));
    }

    @Override
    public String toString() {
        return "Bingo{" +
                "boards=" + boards +
                '}';
    }

    public boolean lastBoardWon() {
        return boards.size()==1 && boards.get(0).hasWon();
    }

    public void removeWinnerBoards() {
        boards = boards.stream().filter(Predicate.not(Board::hasWon)).collect(Collectors.toList());
    }

    public Integer getScore(Integer number) {
        if (!lastBoardWon()) {
            throw new IllegalStateException();
        }
        return boards.get(0).calculateScore(number);
    }
}
