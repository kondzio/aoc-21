package com.kk.aoc21.day2.navi;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Position {
    int horizontal;
    int depth;

    public static Position of(int horizontal, int depth) {
        return new Position(horizontal, depth);
    }
}
