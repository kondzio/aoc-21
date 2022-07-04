package com.kk.aoc21.day5.venture;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LinearVentTest {

    @Test
    void overlappingLinearTest() {
        LinearVent linearVent = new LinearVent(Coordinates.of(0, 0), Coordinates.of(4, 4));
        LinearVent otherLinearVent = new LinearVent(Coordinates.of(1, 1), Coordinates.of(2, 2));
        List<Coordinates> crossPoints = linearVent.calculateCrossPointCoordinates(otherLinearVent);
        assertEquals(crossPoints, otherLinearVent.calculateCrossPointCoordinates(linearVent));
        assertEquals(2, crossPoints.size());
        assertTrue(crossPoints.contains(Coordinates.of(1, 1)));
        assertTrue(crossPoints.contains(Coordinates.of(2, 2)));
    }

    @Test
    void crossingLinearTest() {
        LinearVent linearVent = new LinearVent(Coordinates.of(0, 0), Coordinates.of(4, 4));
        LinearVent otherLinearVent = new LinearVent(Coordinates.of(1, 3), Coordinates.of(3, 1));
        List<Coordinates> crossPoints = linearVent.calculateCrossPointCoordinates(otherLinearVent);
        assertEquals(crossPoints, otherLinearVent.calculateCrossPointCoordinates(linearVent));
        assertEquals(1, crossPoints.size());
        assertTrue(crossPoints.contains(Coordinates.of(2, 2)));
    }

    //        8,0 -> 0,8
    //        9,4 -> 3,4
    @Test
    void specialCase() {
        LinearVent linearVent = new LinearVent(Coordinates.of(8, 0), Coordinates.of(0, 8));
        HorizontalVent horizontalVent = new HorizontalVent(Coordinates.of(9, 4), Coordinates.of(3, 4));
        System.err.println(linearVent.calculateCrossPointCoordinates(horizontalVent));
    }

}