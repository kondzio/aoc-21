package com.kk.aoc21.day3.metric.calculator;

import com.kk.aoc21.day3.report.ReportDecoder;
import com.kk.aoc21.day3.report.ReportDecoder.Metric;
import lombok.NonNull;

public class PowerConsumptionCalculator implements MetricCalculator {
    @Override
    public Metric calculate(@NonNull ReportDecoder.DecodedReport decodedReport) {
        Metric dominantMetric = decodedReport.dominant("0");
        int gammaRate = dominantMetric.asInt();
        int epsilonRate = dominantMetric.negate().asInt();
        return new Metric(Integer.toBinaryString(gammaRate * epsilonRate));
    }
}
