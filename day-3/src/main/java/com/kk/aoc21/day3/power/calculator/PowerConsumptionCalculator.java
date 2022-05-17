package com.kk.aoc21.day3.power.calculator;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PowerConsumptionCalculator implements MetricCalculator {
    private final GammaRateCalculator gammaRateCalculator;

    @Override
    public int calculate(List<String> report) {
        int gammaRate = gammaRateCalculator.calculate(report);
        int epsilonRate = (int) Math.pow(2, report.get(0).length()) - gammaRate - 1;
        return gammaRate * epsilonRate;
    }
}
