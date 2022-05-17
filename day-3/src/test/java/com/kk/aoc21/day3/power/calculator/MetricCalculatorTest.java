package com.kk.aoc21.day3.power.calculator;

import com.kk.aoc21.utils.InputFileLoadUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class MetricCalculatorTest {

    @Test
    void gammaRateTest() {
        List<String> report = InputFileLoadUtils.readLines("test.txt");
        MetricCalculator metricCalculator = new GammaRateCalculator();
        Assertions.assertEquals(22, metricCalculator.calculate(report));
    }
    @Test
    void powerConsumptionTest() {
        List<String> report = InputFileLoadUtils.readLines("test.txt");
        MetricCalculator metricCalculator = new PowerConsumptionCalculator(new GammaRateCalculator());
        Assertions.assertEquals(198, metricCalculator.calculate(report));
    }


}