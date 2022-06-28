package com.kk.aoc21.day3.metric.calculator;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DominantRateCalculator {
    private final String defaultLiteral;

    public String calculate(byte[][] decodedReport, int beginIdx, int endIdx) {
        int rowCount = decodedReport.length;
        int dominantRateLength = Math.min(decodedReport[0].length, endIdx);
        StringBuilder dominantRateBinary = new StringBuilder();
        for (int i = beginIdx; i < dominantRateLength; i++) {
            int positiveLiteralCount = 0;
            for (byte[] line : decodedReport) {
                positiveLiteralCount += (line[i] - 48);
            }
            int negativeLiteralCount = rowCount - positiveLiteralCount;
            if (negativeLiteralCount == positiveLiteralCount) {
                dominantRateBinary.append(defaultLiteral);
            } else {
                dominantRateBinary.append(negativeLiteralCount > positiveLiteralCount ? "0" : "1");
            }
        }
        return dominantRateBinary.toString();
    }

    public String calculate(byte[][] decodedReport) {
        return calculate(decodedReport, 0, decodedReport.length);
    }
}
