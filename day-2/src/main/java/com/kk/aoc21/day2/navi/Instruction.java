package com.kk.aoc21.day2.navi;

import com.kk.aoc21.day2.move.Move;
import com.kk.aoc21.day2.move.MoveFactory;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Instruction {

    private static final MoveFactory moveFactory = new MoveFactory();
    @NonNull
    private final List<Move> moves;

    public Position execute(@NonNull Position startPosition) {
        Position currentPos = startPosition;
        for (Move move : moves) {
            currentPos = move.make(currentPos);
        }
        return currentPos;
    }

    public static Instruction compile(List<String> input) {
        return new Instruction(input.stream().map(moveFactory::createMove).collect(Collectors.toList()));
    }
}
