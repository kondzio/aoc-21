package com.kk.aoc21.day2.navi;

import com.kk.aoc21.day2.move.Move;
import com.kk.aoc21.day2.move.MoveFactory;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Instruction<P> {
    @NonNull
    private final List<Move<P>> moves;

    public P execute(@NonNull P startPosition) {
        P currentPos = startPosition;
        for (Move<P> move : moves) {
            currentPos = move.make(currentPos);
        }
        return currentPos;
    }

    public static <T> Instruction<T> compile(List<String> input, MoveFactory<T> moveFactory) {
        return new Instruction<>(input.stream().map(moveFactory::createMove).collect(Collectors.toList()));
    }
}
