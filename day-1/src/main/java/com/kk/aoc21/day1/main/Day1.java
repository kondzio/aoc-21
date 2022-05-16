package com.kk.aoc21.day1.main;

import com.kk.aoc21.day1.index.comparator.DepthIncreaseCalculator;
import com.kk.aoc21.utils.InputFileLoadUtils;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day1 {


    public static void main(String[] args) {
        Day1 day1 = new Day1();
        Stream<Integer> inputStream = InputFileLoadUtils.readLines("input.txt").stream().map(Integer::parseInt);
        //System.err.println("Part1: " + day1.calculatePart1(inputStream));
        System.err.println("Part2: " + day1.calculatePart2(inputStream));
    }


    public Integer calculatePart1(Stream<Integer> inputStream) {
        return new DepthIncreaseCalculator().calculateMeasure(inputStream.collect(Collectors.toList()), startIndex -> startIndex + 1);
    }


    public Integer calculatePart2(Stream<Integer> inputStream) {
        return new DepthIncreaseCalculator().calculateMeasure(inputStream.collect(Collectors.toList()), startIndex -> startIndex + 3);
    }
}
