package com.kk.aoc21.day1.slice;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Slice<T> {

    @Getter
    private final T representative;

    public static <R> Slice<R> of(@NonNull R representative) {
        return new Slice<>(representative);
    }
}
