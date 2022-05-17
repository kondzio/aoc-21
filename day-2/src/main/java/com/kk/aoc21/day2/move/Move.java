package com.kk.aoc21.day2.move;

import com.kk.aoc21.day2.move.Direction;
import com.kk.aoc21.day2.navi.Position;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public abstract class Move {
    @NonNull
    private final Direction direction;
    private final int speed;

    public abstract Position make(Position position);
}
