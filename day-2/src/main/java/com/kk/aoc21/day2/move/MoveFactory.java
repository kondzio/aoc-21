package com.kk.aoc21.day2.move;

import lombok.NonNull;

public interface MoveFactory<P> {
    Move<P> createMove(@NonNull String inputStep);
}
