package com.kk.aoc21.day1.index.comparator;

import lombok.NonNull;

import java.util.List;

public class DepthIncreaseCalculator implements MeasureCalculator {
    @Override
    public int calculateMeasure(@NonNull List<Integer> input, @NonNull IndexSequencer indexGenerator) {
        int measure = 0;
        int currentIndex = 0;
        int indexToCompare;
        while ((indexToCompare = indexGenerator.nextIndex(currentIndex)) < input.size()) {
            if (input.get(indexToCompare) > input.get(currentIndex)) {
                measure++;
            }
            currentIndex++;
        }
        return measure;
    }
}
