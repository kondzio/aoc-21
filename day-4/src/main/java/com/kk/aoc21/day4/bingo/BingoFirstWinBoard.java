package com.kk.aoc21.day4.bingo;

import com.kk.aoc21.day4.board.Board;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class BingoFirstWinBoard {
    @NonNull
    private final List<Integer> numbers;
    @NonNull
    private final List<Board> boards;

    public long play() {
        for (Integer num : numbers) {
            System.err.println("<--------"+num+"---------->");
            for (Board board : boards) {
                board.print();
                if (board.cross(num)) {
                    return board.score();
                }
            }
            System.err.println("<!--------"+num+"---------->");
        }
        return -1;
    }
}
