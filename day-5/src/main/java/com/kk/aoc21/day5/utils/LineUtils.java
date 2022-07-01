package com.kk.aoc21.day5.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.*;
import java.util.function.Function;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LineUtils {

    public static boolean isBetween(int oneEnd, int secondEnd, int val) {
        return val >= Math.min(oneEnd, secondEnd) && val <= Math.max(oneEnd, secondEnd);
    }

    @SafeVarargs
    public static <T, V extends Comparable<V>> T min(@NonNull Function<T, V> extractor, @NonNull T... items) {
        return min(extractor, Arrays.asList(items));
    }

    public static <T, V extends Comparable<V>> T min(@NonNull Function<T, V> extractor, @NonNull List<T> items) {
        Map<V, T> byValue = new HashMap<>();
        items.forEach(i -> byValue.put(extractor.apply(i), i));
        return byValue.get(Collections.min(byValue.keySet()));
    }
    @SafeVarargs
    public static <T, V extends Comparable<V>> T max(@NonNull Function<T, V> extractor, @NonNull T... items) {
        return max(extractor, Arrays.asList(items));
    }

    public static <T, V extends Comparable<V>> T max(@NonNull Function<T, V> extractor, @NonNull List<T> items) {
        Map<V, T> byValue = new HashMap<>();
        items.forEach(i -> byValue.put(extractor.apply(i), i));
        return byValue.get(Collections.max(byValue.keySet()));
    }
}
