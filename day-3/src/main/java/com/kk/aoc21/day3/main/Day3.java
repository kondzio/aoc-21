package com.kk.aoc21.day3.main;

import com.kk.aoc21.day3.metric.calculator.Co2ScrubberRateCalculator;
import com.kk.aoc21.day3.metric.calculator.OxygenGenerateRateCalculator;
import com.kk.aoc21.day3.metric.calculator.PowerConsumptionCalculator;
import com.kk.aoc21.day3.report.ReportDecoder;
import com.kk.aoc21.utils.InputFileLoadUtils;

public class Day3 {
    public static void main(String[] args) {
        calculatePart2();
    }

    private static void calculatePart1() {
        PowerConsumptionCalculator powerConsumptionCalculator = new PowerConsumptionCalculator();
        System.err.println(powerConsumptionCalculator.calculate(ReportDecoder.decode(InputFileLoadUtils.readLines("input.txt"))));
    }

    private static void calculatePart2() {
        ReportDecoder.DecodedReport decodedReport = ReportDecoder.decode(InputFileLoadUtils.readLines("input.txt"));

        OxygenGenerateRateCalculator oxygenGenerateRateCalculator = new OxygenGenerateRateCalculator();
        ReportDecoder.Metric oxygenGenerateRateMetric = oxygenGenerateRateCalculator.calculate(decodedReport);

        Co2ScrubberRateCalculator co2ScrubberRateCalculator = new Co2ScrubberRateCalculator();
        ReportDecoder.Metric co2ScrubberMetric = co2ScrubberRateCalculator.calculate(decodedReport);

        System.err.println(oxygenGenerateRateMetric.asInt() * co2ScrubberMetric.asInt());
    }
}
