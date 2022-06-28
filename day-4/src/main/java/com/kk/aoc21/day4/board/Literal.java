package com.kk.aoc21.day4.board;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@ToString
public class Literal<T> {
    private final T value;
    private boolean crossed;

    public void cross() {
        crossed = true;
    }
}
