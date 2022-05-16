package com.kk.aoc21.day1.aggregator;

import com.kk.aoc21.day1.slice.Slice;
import com.kk.aoc21.day1.slice.Slicer;
import com.kk.aoc21.utils.InputFileLoadUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.stream.Stream;

class AggregatorTest {

    @Test
    void day1p1Test() {
        Stream<Integer> inputStream = InputFileLoadUtils.readLines("test1.txt").stream().map(Integer::parseInt);
        Slicer<Integer> slicer = new Slicer<>(inputStream);
        Aggregator<Integer> aggregator = new Aggregator<>(slicer.slice(integerIterator -> Slice.of(integerIterator.next())));
        Integer result = aggregator.aggregate(0, (resultHolder, prev, next) -> resultHolder.setResult(resultHolder.getResult() + (prev == null || (next.getRepresentative() > prev.getRepresentative()) ? 1 : 0)));
        Assertions.assertEquals(7, result);
    }

    @Test
    void day1p2Test() {
//        Stream<Integer> inputStream = Stream.of(input.split("\\n")).map(Integer::parseInt);
//        Slicer<Integer> slicer = new Slicer<>(inputStream);
//        Aggregator<Integer> aggregator = new Aggregator<>(slicer.slice(integerIterator -> Slice.of(integerIterator.next())));
//        Integer result = aggregator.aggregate(0, (resultHolder, prev, next) -> resultHolder.setResult(resultHolder.getResult() + (prev == null || (next.getRepresentative() > prev.getRepresentative()) ? 1 : 0)));
//        System.err.println(result);
    }
}
