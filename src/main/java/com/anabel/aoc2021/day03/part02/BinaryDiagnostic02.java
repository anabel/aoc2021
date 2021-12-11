package com.anabel.aoc2021.day03.part02;

import java.util.stream.Stream;

import static com.anabel.aoc2021.day03.part02.ReportAdapter.toDiagnosticReport;

public class BinaryDiagnostic02 {
    public static String solve(Stream<String> report) {
        Report diagnosticReport = toDiagnosticReport(report);
        return String.valueOf(diagnosticReport.calculateLifeSupportRating());
    }
}
