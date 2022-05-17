package com.kk.aoc21.day2.move;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Optional;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public enum Direction {
    UP("up"), DOWN("down"), FORWARD("forward");

    @NonNull
    @Getter
    private final String literal;

    public static Optional<Direction> getByLiteral(@NonNull String literal) {
        return Arrays.stream(values()).filter(direction -> direction.getLiteral().equals(literal)).findFirst();
    }
}
