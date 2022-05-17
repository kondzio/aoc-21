package com.kk.aoc21.day3.power.calculator;

import java.util.List;

public class GammaRateCalculator implements MetricCalculator {
    @Override
    public int calculate(List<String> report) {
        int rowCount = report.size();
        byte[][] log = new byte[rowCount][];
        for (int i = 0; i < rowCount; i++) {
            log[i] = report.get(i).getBytes();
        }

        int gammaLength = log[0].length;
        StringBuilder gammaRateBinary = new StringBuilder();
        for (int i = 0; i < gammaLength; i++) {
            int positiveCount = 0;
            for (byte[] line : log) {
                positiveCount += (line[i] - 48);
            }
            gammaRateBinary.append(((rowCount - positiveCount) > positiveCount) ? "0" : "1");
        }
        return Integer.parseInt(gammaRateBinary.toString(), 2);
    }
}
