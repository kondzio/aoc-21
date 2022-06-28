package com.kk.aoc21.day4.bingo;

import com.kk.aoc21.day4.board.Board;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public abstract class BaseBingo implements Bingo {
    @NonNull
    protected final List<Integer> numbers;
    @NonNull
    protected final List<Board> boards;
}
