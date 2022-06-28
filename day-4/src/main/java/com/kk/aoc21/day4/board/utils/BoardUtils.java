package com.kk.aoc21.day4.board.utils;

import com.kk.aoc21.day4.board.Board;
import com.kk.aoc21.day4.board.Line;
import com.kk.aoc21.day4.board.Literal;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BoardUtils {
    private final static int BOARD_SIZE = 5;

    public static Board readBoard(List<String> lines, int begin, int end) {
        Board board = new Board();
        for (int i = begin; i < end; i++) {
            var rows = Arrays.stream(lines.get(i).trim().split("\\s+")).map(token -> new Literal<>(Integer.parseInt(token))).collect(Collectors.toList());
            board.addRow(Line.of(rows));
        }
        return board;
    }

    public static List<Board> readBoards(List<String> lines, int cursor) {
        List<Board> boards = new ArrayList<>();
        for (int cur = cursor; cur < lines.size(); cur += (BOARD_SIZE + 1)) {
            Board board = readBoard(lines, cur, cur + BOARD_SIZE);
            boards.add(board);
        }
        return boards;
    }
}
