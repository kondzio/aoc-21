package com.kk.aoc21.day4.board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private Board board;

    @BeforeEach
    void setUp() {
        this.board = new Board();
        board.addRow(Line.of(Arrays.asList(new Literal<>(1), new Literal<>(2), new Literal<>(3))));
        board.addRow(Line.of(Arrays.asList(new Literal<>(4), new Literal<>(5), new Literal<>(6))));
        board.addRow(Line.of(Arrays.asList(new Literal<>(7), new Literal<>(8), new Literal<>(9))));
    }

    @Test
    void crossTest1() {
        assertFalse(board.cross(4));
        assertFalse(board.cross(5));
        assertTrue(board.cross(6));
        assertTrue(board.isWin());

        board.print();

        assertEquals(6 * (1 + 2 + 3 + 7 + 8 + 9), board.score());
    }

    @Test
    void crossTest2() {
        assertFalse(board.cross(3));
        assertFalse(board.cross(6));
        assertTrue(board.cross(9));
        assertTrue(board.isWin());

        board.print();

        assertEquals(9 * (1 + 2 + 4 + 5 + 7 + 8), board.score());
    }

}