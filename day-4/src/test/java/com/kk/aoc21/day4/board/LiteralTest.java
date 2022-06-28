package com.kk.aoc21.day4.board;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LiteralTest {

    @Test
    void crossTest() {
        Literal<Integer> literal = new Literal<>(12);
        assertFalse(literal.isCrossed());
        literal.cross();
        assertTrue(literal.isCrossed());
    }

}