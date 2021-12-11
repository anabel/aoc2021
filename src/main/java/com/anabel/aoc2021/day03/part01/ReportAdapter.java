package com.anabel.aoc2021.day03.part01;

import java.util.stream.Stream;

public class ReportAdapter {

    private ReportAdapter() {}

    public static Report toDiagnosticReport(Stream<String> report) {
        Report diagnosticReport = new Report();
        report.forEach(diagnosticReport::addNumber);
        return diagnosticReport;
    }
}
