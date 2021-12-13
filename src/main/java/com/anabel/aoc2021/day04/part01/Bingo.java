package com.anabel.aoc2021.day04.part01;

import java.util.List;

public class Bingo {
    List<Board> boards;

    public Bingo(List<Board> boards) {
        this.boards = boards;
    }

    public void drawNumber(Integer number) {
        boards.forEach(b -> b.numberDrawn(number));
    }

    public boolean thereIsNoWinnerBoard() {
        return boards.stream().noneMatch(Board::hasWon);
    }

    @Override
    public String toString() {
        return "Bingo{" +
                "boards=" + boards +
                '}';
    }

    public Integer getScore(Integer number) {
        if (thereIsNoWinnerBoard()) {
            throw new IllegalStateException();
        }
        Board winningBoard = boards.stream().filter(Board::hasWon).findFirst().orElseThrow(IllegalStateException::new);
        return winningBoard.calculateScore(number);
    }
}
