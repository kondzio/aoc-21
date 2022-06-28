package com.kk.aoc21.day3.metric.calculator;

import com.kk.aoc21.day3.report.ReportDecoder;
import com.kk.aoc21.day3.report.ReportDecoder.DecodedReport;

public class EpsilonRateCalculator implements MetricCalculator {
    @Override
    public ReportDecoder.Metric calculate(DecodedReport decodedReport) {
        return decodedReport.dominant("0").negate();
    }
}
