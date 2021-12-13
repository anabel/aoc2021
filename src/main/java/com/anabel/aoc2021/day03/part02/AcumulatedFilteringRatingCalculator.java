package com.anabel.aoc2021.day03.part02;

import java.util.function.BinaryOperator;

public class AcumulatedFilteringRatingCalculator {
    Matrix numbers;

    public AcumulatedFilteringRatingCalculator(Matrix numbers) {
        this.numbers = numbers;
    }

    public Rate execute(BinaryOperator<Integer> bitCriteria) {
        int position = 0;
        do {
            Integer onesTotal = numbers.transpose().sum(position);
            Integer total = numbers.getRows();
            Integer bit = bitCriteria.apply(onesTotal, total);
            numbers = numbers.removeRowsThatContain(bit, position);
            position++;
        } while (numbers.getRows()>1);
        return new Rate(numbers.getRow(0));
    }
}
