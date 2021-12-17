package com.anabel.aoc2021.day03.part01;

import java.util.stream.Stream;

public class BinaryDiagnostic01 {
    public static String solve(Stream<String> report) {
        Report diagnosticReport = ReportAdapter.toDiagnosticReport(report);
        return String.valueOf(diagnosticReport.calculateSubmarineConsumption());
    }
}
