package com.kk.aoc21.day3.power.calculator;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Arrays;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MetricUtils {
    public static int toIntMetric(@NonNull String binaryMetric) {
        return Integer.parseInt(binaryMetric, 2);
    }

    public static String toBinaryString(byte[] arr) {
        return new String(arr);
    }

    public static int toIntMetric(@NonNull byte[] arr) {
        return Integer.parseInt(toBinaryString(arr), 2);
    }
}
