package com.kk.aoc21.day5.venture;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class Coordinates {
    private final int x;
    private final int y;

    public static Coordinates of(int x, int y) {
        return new Coordinates(x, y);
    }
}
