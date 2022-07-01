package com.kk.aoc21.day5.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LineUtils {

    public static boolean isBetween(int oneEnd, int secondEnd, int val) {
        return val >= Math.min(oneEnd, secondEnd) && val <= Math.max(oneEnd, secondEnd);
    }
}
