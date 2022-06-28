package com.kk.aoc21.day4.main;

import com.kk.aoc21.day4.bingo.BingoFirstWinBoard;
import com.kk.aoc21.day4.board.Board;
import com.kk.aoc21.utils.InputFileLoadUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.kk.aoc21.day4.board.utils.BoardUtils.readBoards;

public class Day4 {

    public static void main(String[] args) {
        List<String> lines = InputFileLoadUtils.readLines("input.txt");
        List<Integer> numbers = Arrays.stream(lines.get(0).split(",")).map(Integer::parseInt).collect(Collectors.toList());
        List<Board> boards = readBoards(lines, 2);
        System.err.println(new BingoFirstWinBoard(numbers, boards).play());
    }
}
