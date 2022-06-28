package com.kk.aoc21.day3.metric.calculator;

import com.kk.aoc21.day3.report.ReportDecoder;
import com.kk.aoc21.day3.report.ReportDecoder.Metric;
import lombok.NonNull;

public interface MetricCalculator {
    Metric calculate(@NonNull ReportDecoder.DecodedReport decodedReport);
}
