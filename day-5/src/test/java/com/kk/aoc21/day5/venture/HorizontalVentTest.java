package com.kk.aoc21.day5.venture;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HorizontalVentTest {
    @Test
    void horizontalTest() {
        HorizontalVent horizontalVent = new HorizontalVent(Coordinates.of(0, 1), Coordinates.of(4, 1));
        HorizontalVent otherHorizontalVent = new HorizontalVent(Coordinates.of(2, 1), Coordinates.of(3, 1));
        List<Coordinates> crossPoints = horizontalVent.calculateCrossPointCoordinates(otherHorizontalVent);
        assertEquals(crossPoints, otherHorizontalVent.calculateCrossPointCoordinates(horizontalVent));
        assertEquals(2, crossPoints.size());
        assertTrue(crossPoints.contains(Coordinates.of(2, 1)));
        assertTrue(crossPoints.contains(Coordinates.of(3, 1)));
    }

    @Test
    void verticalTest() {
        HorizontalVent horizontalVent = new HorizontalVent(Coordinates.of(0, 1), Coordinates.of(4, 1));
        VerticalVent verticalVent = new VerticalVent(Coordinates.of(2, 1), Coordinates.of(2, -1));
        List<Coordinates> crossPoints = horizontalVent.calculateCrossPointCoordinates(verticalVent);
        assertEquals(crossPoints, verticalVent.calculateCrossPointCoordinates(horizontalVent));
        assertEquals(1, crossPoints.size());
        assertTrue(crossPoints.contains(Coordinates.of(2, 1)));
    }

    @Test
    void linearTest() {
        HorizontalVent horizontalVent = new HorizontalVent(Coordinates.of(0, 1), Coordinates.of(4, 1));
        VerticalVent linearVent = new VerticalVent(Coordinates.of(2, 1), Coordinates.of(2, 2));
        List<Coordinates> crossPoints = horizontalVent.calculateCrossPointCoordinates(linearVent);
        assertEquals(crossPoints, linearVent.calculateCrossPointCoordinates(horizontalVent));
        assertEquals(1, crossPoints.size());
        assertTrue(crossPoints.contains(Coordinates.of(2, 1)));
    }
}