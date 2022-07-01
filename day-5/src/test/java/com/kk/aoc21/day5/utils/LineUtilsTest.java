package com.kk.aoc21.day5.utils;

import com.kk.aoc21.day5.venture.Coordinates;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LineUtilsTest {

    @Test
    void minTest() {
        Coordinates minY = Coordinates.of(2, 1);
        Coordinates maxX = Coordinates.of(3, 3);
        Coordinates min = LineUtils.min(Coordinates::getY, Coordinates.of(1, 2), minY, maxX);
        assertEquals(minY, min);
        Coordinates max = LineUtils.max(Coordinates::getX, Coordinates.of(1, 2), minY, maxX);
        assertEquals(maxX, max);
    }

}