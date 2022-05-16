package com.kk.aoc21.day1.index.comparator;

import lombok.NonNull;

import java.util.List;

public interface MeasureCalculator {

    int calculateMeasure(@NonNull List<Integer> input, @NonNull IndexSequencer indexGenerator);
}
