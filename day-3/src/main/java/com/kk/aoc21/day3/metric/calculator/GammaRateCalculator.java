package com.kk.aoc21.day3.metric.calculator;

import com.kk.aoc21.day3.report.ReportDecoder;
import com.kk.aoc21.day3.report.ReportDecoder.Metric;

public class GammaRateCalculator implements MetricCalculator {

    @Override
    public Metric calculate(ReportDecoder.DecodedReport decodedReport) {
        return decodedReport.dominant("0");
    }
}
