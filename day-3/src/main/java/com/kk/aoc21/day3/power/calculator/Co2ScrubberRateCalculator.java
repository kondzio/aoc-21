package com.kk.aoc21.day3.power.calculator;

import com.kk.aoc21.day3.report.ReportDecoder;
import lombok.NonNull;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Co2ScrubberRateCalculator implements MetricCalculator{
    @Override
    public ReportDecoder.Metric calculate(@NonNull ReportDecoder.DecodedReport decodedReport) {
        Set<Integer> indexes = Stream.iterate(0, idx -> idx + 1).limit(decodedReport.length()).collect(Collectors.toSet());
        int dominantIndex = 0;
        while (indexes.size() > 1) {
            indexes = selectIndexes(decodedReport, decodedReport.filter(indexes).dominant("1", dominantIndex, dominantIndex+1).asBinaryString(), indexes, dominantIndex);
            dominantIndex++;
        }
        Integer selectedIndex = indexes.stream().findFirst().orElseThrow(IllegalStateException::new);
        return new ReportDecoder.Metric(MetricUtils.toBinaryString(decodedReport.getBinaryReport()[selectedIndex]));
    }

    private Set<Integer> selectIndexes(ReportDecoder.DecodedReport decodedReport, String dominantMetric, Set<Integer> indexes, int dominantIdx) {
        Set<Integer> selectedIndexes = new HashSet<>();
        byte dominant = (byte) dominantMetric.charAt(0);
        for (Integer index : indexes) {
            if (decodedReport.getBinaryReport()[index][dominantIdx] != dominant) {
                selectedIndexes.add(index);
            }
        }
        return selectedIndexes;
    }
}
