package com.kk.aoc21.day1.index.comparator;

import com.kk.aoc21.day1.main.Day1;
import com.kk.aoc21.utils.InputFileLoadUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

class DepthIncreaseCalculatorTest {

    @Test
    void day1p1Test() {
        Stream<Integer> inputStream = InputFileLoadUtils.readLines("test1.txt").stream().map(Integer::parseInt);
        Assertions.assertEquals(7, new Day1().calculatePart1(inputStream));
    }

    @Test
    void day1p2Test() {
        Stream<Integer> inputStream = InputFileLoadUtils.readLines("test1.txt").stream().map(Integer::parseInt);
        Assertions.assertEquals(5, new Day1().calculatePart2(inputStream));
    }
}
