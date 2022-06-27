package com.kk.aoc21.day3.power.calculator;

import com.kk.aoc21.day3.report.ReportDecoder;
import com.kk.aoc21.utils.InputFileLoadUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class MetricCalculatorTest {

    @Test
    void gammaRateTest() {
        List<String> report = InputFileLoadUtils.readLines("test.txt");
        MetricCalculator metricCalculator = new GammaRateCalculator();
        Assertions.assertEquals(22, metricCalculator.calculate(ReportDecoder.decode(report)).asInt());
    }

    @Test
    void powerConsumptionTest() {
        List<String> report = InputFileLoadUtils.readLines("test.txt");
        MetricCalculator metricCalculator = new PowerConsumptionCalculator();
        Assertions.assertEquals(198, metricCalculator.calculate(ReportDecoder.decode(report)).asInt());
    }

    @Test
    void oxygenGenerateRateTest() {
        List<String> report = InputFileLoadUtils.readLines("test.txt");
        MetricCalculator metricCalculator = new OxygenGenerateRateCalculator();
        Assertions.assertEquals(23, metricCalculator.calculate(ReportDecoder.decode(report)).asInt());
    }

    @Test
    void co2ScrubberRateTest() {
        List<String> report = InputFileLoadUtils.readLines("test.txt");
        MetricCalculator metricCalculator = new Co2ScrubberRateCalculator();
        Assertions.assertEquals(10, metricCalculator.calculate(ReportDecoder.decode(report)).asInt());
    }
}