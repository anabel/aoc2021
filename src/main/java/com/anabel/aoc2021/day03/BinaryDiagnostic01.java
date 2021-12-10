package com.anabel.aoc2021.day03;

import java.util.stream.Stream;

import static com.anabel.aoc2021.day03.ReportAdapter.toDiagnosticReport;

public class BinaryDiagnostic01 {
    public static String solve(Stream<String> report) {
        Report diagnosticReport = toDiagnosticReport(report);
        return String.valueOf(diagnosticReport.calculateSubmarineConsumption());
    }
}
