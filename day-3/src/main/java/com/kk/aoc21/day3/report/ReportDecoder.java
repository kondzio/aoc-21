package com.kk.aoc21.day3.report;

import com.kk.aoc21.day3.metric.calculator.DominantRateCalculator;
import com.kk.aoc21.day3.metric.calculator.MetricUtils;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Set;

public class ReportDecoder {

    public static DecodedReport decode(@NonNull List<String> report) {
        int rowCount = report.size();
        byte[][] binaryReport = new byte[rowCount][];
        for (int i = 0; i < rowCount; i++) {
            binaryReport[i] = report.get(i).getBytes();
        }
        return new DecodedReport(binaryReport);
    }

    @RequiredArgsConstructor
    public static class DecodedReport {
        @NonNull
        private final byte[][] binaryReport;

        public Metric dominant(String defaultLiteral) {
            return new Metric(new DominantRateCalculator(defaultLiteral).calculate(binaryReport));
        }

        public Metric dominant(String defaultLiteral, int begin, int end) {
            return new Metric(new DominantRateCalculator(defaultLiteral).calculate(binaryReport, begin, end));
        }

        public DecodedReport filter(Set<Integer> indexes) {
            if (indexes.size() == binaryReport.length) {
                return this;
            }
            return new DecodedReport(indexes.stream().map(idx -> binaryReport[idx]).toArray(val -> new byte[indexes.size()][]));
        }

        public byte[][] getBinaryReport() {
            return binaryReport;
        }

        public byte[][] getBinaryReport(Set<Integer> indexes) {
            return indexes.stream().map(idx -> binaryReport[idx]).toArray(value -> new byte[indexes.size()][]);
        }

        public int length() {
            return binaryReport.length;
        }
    }

    @RequiredArgsConstructor
    public static class Metric {
        @NonNull
        private final String binaryMetric;

        public String asBinaryString() {
            return binaryMetric;
        }

        public int asInt() {
            return MetricUtils.toIntMetric(binaryMetric);
        }

        public Metric negate() {
            return new Metric(Integer.toBinaryString((int) (Math.pow(2, binaryMetric.length()) - 1) ^ asInt()));
        }
    }
}
