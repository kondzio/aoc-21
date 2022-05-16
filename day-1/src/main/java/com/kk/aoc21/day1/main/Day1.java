package com.kk.aoc21.day1.main;

import com.kk.aoc21.day1.aggregator.Aggregator;
import com.kk.aoc21.day1.slice.Slice;
import com.kk.aoc21.day1.slice.Slicer;
import com.kk.aoc21.utils.InputFileLoadUtils;

import java.io.IOException;
import java.util.stream.Stream;

public class Day1 {


    public static void main(String[] args) {
        Day1 day1 = new Day1();
        Stream<Integer> inputStream = InputFileLoadUtils.readLines("input.txt").stream().map(Integer::parseInt);
        System.err.println(day1.calculatePart1(inputStream));
    }


    public Integer calculatePart1(Stream<Integer> inputStream) {
        Slicer<Integer> slicer = new Slicer<>(inputStream);
        Aggregator<Integer> aggregator = new Aggregator<>(slicer.slice(integerIterator -> Slice.of(integerIterator.next())));
        return aggregator.aggregate(0, (resultHolder, prev, next) -> resultHolder.setResult(resultHolder.getResult() + (prev == null || (next.getRepresentative() > prev.getRepresentative()) ? 1 : 0)));
    }

    public Integer calculatePart2(Stream<Integer> inputStream) {
        Slicer<Integer> slicer = new Slicer<>(inputStream);
        Aggregator<Integer> aggregator = new Aggregator<>(slicer.slice(integerIterator -> Slice.of(integerIterator.next())));
        return aggregator.aggregate(0, (resultHolder, prev, next) -> resultHolder.setResult(resultHolder.getResult() + (prev == null || (next.getRepresentative() > prev.getRepresentative()) ? 1 : 0)));
    }
}
