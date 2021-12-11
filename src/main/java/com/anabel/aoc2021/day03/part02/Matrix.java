package com.anabel.aoc2021.day03.part02;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.IntStream;

public class Matrix {
    private Integer rows;
    private Integer columns=0;
    private LinkedList<Integer>[] values;

    public Matrix(Integer rows) {
        this.rows = rows;
        initialize();
    }

    public Matrix(LinkedList<Integer>[] values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException();
        }
        this.rows = values.length;
        this.columns = values[0].size();
        this.values = values;
    }

    private void initialize() {
        this.values = new LinkedList[rows];
        IntStream.range(0, rows).forEach(i-> values[i]=new LinkedList<>());
    }

    public void addColumn(Integer[] column) {
        for(int i=0; i < column.length; i++) {
            values[i].add(column[i]);
        }
        columns++;
    }

    public Integer[] getColumn(int position) {
        if (position > this.columns) {
            throw new IllegalArgumentException();
        }
        return IntStream.range(0, this.columns)
                .mapToObj(j -> values[position].get(j))
                .toArray(Integer[]::new);
    }

    public Integer getColumns() {
        return columns;
    }

    public Integer[] getRow(int position) {
        if (position > this.rows) {
            throw new IllegalArgumentException();
        }
        return values[position].toArray(Integer[]::new);
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "Matrix{" +
                "rows=" + rows +
                ", columns=" + columns +
                ", values=" + Arrays.toString(values) +
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

    public Matrix transpose() {
        Matrix transposed = new Matrix(this.columns);
        for(int i=0; i < this.rows; i++) {
            transposed.addColumn(getRow(i));
        }
        return transposed;
    }

    public Matrix removeRowsThatContain(Integer value, Integer position){
        LinkedList<Integer>[] filtered = Arrays.stream(values)
                .filter(n -> n.get(position)!=value)
                .toArray(LinkedList[]::new);
        return new Matrix(filtered);
    }
}
