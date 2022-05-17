package com.kk.aoc21.day2.navi;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class BasePosition {
    int horizontal;
    int depth;

    public static BasePosition of(int horizontal, int depth) {
        return new BasePosition(horizontal, depth);
    }
}
