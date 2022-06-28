package com.kk.aoc21.day4.bingo;

import com.kk.aoc21.day4.board.Board;
import com.kk.aoc21.utils.InputFileLoadUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.kk.aoc21.day4.board.utils.BoardUtils.readBoards;
import static org.junit.jupiter.api.Assertions.*;

class BingoFirstWinBoardTest {

    @Test
    void mainTest() {
        List<String> lines = InputFileLoadUtils.readLines("test.txt");
        List<Integer> numbers = Arrays.stream(lines.get(0).split(",")).map(Integer::parseInt).collect(Collectors.toList());
        List<Board> boards = readBoards(lines, 2);
        assertEquals(4512, new BingoFirstWinBoard(numbers, boards).play());
    }
}