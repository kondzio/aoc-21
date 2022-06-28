package com.kk.aoc21.day4.bingo;

import com.kk.aoc21.day4.board.Board;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

public class BingoFirstWinBoard extends BaseBingo {

    public BingoFirstWinBoard(@NonNull List<Integer> numbers, @NonNull List<Board> boards) {
        super(numbers, boards);
    }

    @Override
    public long play() {
        for (Integer num : numbers) {
            System.err.println("<--------" + num + "---------->");
            for (Board board : boards) {
                board.print();
                if (board.cross(num)) {
                    return board.score();
                }
            }
            System.err.println("<!--------" + num + "---------->");
        }
        return -1;
    }
}
