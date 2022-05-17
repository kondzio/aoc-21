package com.kk.aoc21.day2.move;

import com.kk.aoc21.day2.navi.BasePosition;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public abstract class Move<P> {
    @NonNull
    private final Direction direction;
    private final int speed;

    public abstract P make(P position);
}
