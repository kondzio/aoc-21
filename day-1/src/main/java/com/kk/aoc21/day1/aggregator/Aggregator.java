package com.kk.aoc21.day1.aggregator;

import com.kk.aoc21.day1.slice.Slice;
import lombok.*;

import java.util.Iterator;
import java.util.stream.Stream;

@RequiredArgsConstructor
public class Aggregator<T> {
    @NonNull
    private final Stream<Slice<T>> inputStream;

    public <R> R aggregate(R identity, AggregateFunc<R, T> aggregateFunc) {
        Slice<T> prev = null;
        Slice<T> next;

        ResultHolder<R> resultHolder = new ResultHolder<>(identity);

        Iterator<Slice<T>> iterator = inputStream.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            aggregateFunc.aggregateNext(resultHolder, prev, next);
            prev = next;
        }
        return resultHolder.getResult();
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class ResultHolder<T> {
        private T result;
    }
}
