package com.kk.aoc21.day1.slice;

import lombok.NonNull;

import java.util.Iterator;
import java.util.function.Function;
import java.util.stream.Stream;

public class Slicer<T> {
    private final Iterator<T> iterator;

    public Slicer(@NonNull Stream<T> inputStream) {
        this.iterator = inputStream.iterator();
    }

    public Stream<Slice<T>> slice(@NonNull Function<Iterator<T>, Slice<T>> sliceFunc) {
        return Stream.generate(() -> sliceFunc.apply(iterator)).takeWhile(slice -> iterator.hasNext());
    }
}
