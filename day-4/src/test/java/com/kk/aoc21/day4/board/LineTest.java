package com.kk.aoc21.day4.board;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LineTest {

    @Test
    void crossTest() {
        Line<Integer> line = Line.of(Arrays.asList(new Literal<>(1), new Literal<>(2), new Literal<>(3)));
        assertFalse(line.cross(4));
        assertFalse(line.cross(3));
        assertFalse(line.cross(2));
        assertTrue(line.cross(1));
        assertTrue(line.isCrossed());
    }

}