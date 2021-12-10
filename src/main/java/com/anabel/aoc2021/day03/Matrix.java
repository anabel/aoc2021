package com.anabel.aoc2021.day03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Matrix {
    private Integer rows;
    private Integer columns=0;
    private List<Integer>[] values;

    public Matrix(Integer rows) {
        this.rows = rows;
        initialize();
    }

    private void initialize() {
        this.values = new ArrayList[rows];
        IntStream.range(0, rows).forEach(i-> values[i]=new ArrayList<>());
    }

    public void addColumn(Integer[] column) {
        for(int i=0; i < column.length; i++) {
            values[i].add(column[i]);
        }
        columns++;
    }

    public Integer getColumns() {
        return columns;
    }

    @Override
    public String toString() {
        return "Matrix{" +
                "values=" + Arrays.toString(values) +
                '}';
    }

    public Integer sum(int i) {
        if(i>rows) {
            throw new IllegalArgumentException();
        }
        return values[i].stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
