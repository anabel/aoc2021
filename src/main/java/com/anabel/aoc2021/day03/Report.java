package com.anabel.aoc2021.day03;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Report {
    private Matrix transposedNumbers;
    private Rate onesRate;
    private Rate gammaRate;
    private Rate epsilonRate;

    public void addNumber(String number) {
       Integer[] column = Arrays.stream(number.split("")).mapToInt(Integer::valueOf)
               .boxed()
               .toArray(Integer[]::new);
       if(transposedNumbers == null) {
           initializeMatrix(column.length);
       }
       transposedNumbers.addColumn(column);
    }

    private void initializeMatrix(Integer numberLength) {
        transposedNumbers = new Matrix(numberLength);
        BinaryNumber.setLength(numberLength);
    }

    public Integer calculateSubmarineConsumption() {
        calculateOnesRate();
        calculateGammaRate();
        calculateEpsilonRate();
        return gammaRate.toBinaryNumber().toDecimal() * epsilonRate.toBinaryNumber().toDecimal();
    }

    private void calculateOnesRate() {
        Integer[] ones = new Integer[BinaryNumber.LENGTH];
        IntStream.range(0, BinaryNumber.LENGTH).forEach(i-> ones[i] = transposedNumbers.sum(i));
        onesRate = new Rate(ones);
    }

    private void calculateGammaRate() {
        Integer[] gamma = new Integer[BinaryNumber.LENGTH];
        Integer total = transposedNumbers.getColumns();
        IntStream.range(0, BinaryNumber.LENGTH).forEach(i-> gamma[i] = Bit.mostCommon(onesRate.get(i), total));
        gammaRate = new Rate(gamma);
    }

    private void calculateEpsilonRate() {
        Integer[] epsilon = new Integer[BinaryNumber.LENGTH];
        Integer total = transposedNumbers.getColumns();
        IntStream.range(0, BinaryNumber.LENGTH).forEach(i-> epsilon[i] = Bit.lessCommon(onesRate.get(i), total));
        epsilonRate = new Rate(epsilon);
    }

    @Override
    public String toString() {
        return "DiagnosticReport{" +
                "transposedNumbers=" + transposedNumbers +
                ", onesRate=" + onesRate +
                ", gammaRate=" + gammaRate +
                ", epsilonRate=" + epsilonRate +
                '}';
    }
}
