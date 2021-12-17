package com.anabel.aoc2021.day03.part02;

import java.util.stream.Stream;

public class BinaryDiagnostic02 {
    public static String solve(Stream<String> report) {
        Report diagnosticReport = ReportAdapter.toDiagnosticReport(report);
        return String.valueOf(diagnosticReport.calculateLifeSupportRating());
    }
}
