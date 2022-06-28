package com.kk.aoc21.day4.bingo;

import com.kk.aoc21.day4.board.Board;
import lombok.NonNull;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class BingoLastWinBoard extends BaseBingo {
    public BingoLastWinBoard(@NonNull List<Integer> numbers, @NonNull List<Board> boards) {
        super(numbers, boards);
    }

    public long play() {
        AtomicReference<Board> latestWinBoardHolder = new AtomicReference<>();
        for (Integer num : numbers) {
            System.err.println("<--------" + num + "---------->");
            boards.stream().filter(board -> !board.isWin()).forEach(board -> {
                if (board.cross(num)) {
                    latestWinBoardHolder.set(board);
                }
            });
            System.err.println("<!--------" + num + "---------->");
        }

        return latestWinBoardHolder.get() == null ? -1 : latestWinBoardHolder.get().score();
    }
}
