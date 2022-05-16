package com.kk.aoc21.day1.aggregator;

import com.kk.aoc21.day1.slice.Slice;
import lombok.NonNull;

public interface AggregateFunc<R, T> {
    void aggregateNext(@NonNull Aggregator.ResultHolder<R> resultHolder, Slice<T> prev, Slice<T> next);
}
