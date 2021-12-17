package com.anabel.aoc2021.day05.part02;

public record Position(int x, int y) {
    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public boolean isSmallerThan(Position position) {
        if(this.isHorizontallyAligned(position)) {
            return this.y() < position.y();
        } else {
            return this.x() < position.x();
        }
    }

    public boolean isHorizontallyAligned(Position b) {
        return this.x() == b.x();
    }

}
