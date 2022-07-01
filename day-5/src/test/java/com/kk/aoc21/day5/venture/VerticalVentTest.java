package com.kk.aoc21.day5.venture;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VerticalVentTest {
    @Test
    void horizontalTest() {
        VerticalVent verticalVent = new VerticalVent(Coordinates.of(1, 0), Coordinates.of(1, 4));
        HorizontalVent horizontalVent = new HorizontalVent(Coordinates.of(0, 1), Coordinates.of(2, 1));
        List<Coordinates> crossPoints = verticalVent.calculateCrossPointCoordinates(horizontalVent);
        assertEquals(crossPoints, horizontalVent.calculateCrossPointCoordinates(verticalVent));
        assertEquals(1, crossPoints.size());
        assertTrue(crossPoints.contains(Coordinates.of(1, 1)));
    }

    @Test
    void verticalTest() {
        VerticalVent verticalVent = new VerticalVent(Coordinates.of(1, 0), Coordinates.of(1, 4));
        VerticalVent otherVerticalVent = new VerticalVent(Coordinates.of(1, 1), Coordinates.of(1, 2));
        List<Coordinates> crossPoints = verticalVent.calculateCrossPointCoordinates(otherVerticalVent);
        assertEquals(crossPoints, otherVerticalVent.calculateCrossPointCoordinates(verticalVent));
        assertEquals(2, crossPoints.size());
        assertTrue(crossPoints.contains(Coordinates.of(1, 1)));
        assertTrue(crossPoints.contains(Coordinates.of(1, 2)));
    }

    @Test
    void linearTest() {
        VerticalVent verticalVent = new VerticalVent(Coordinates.of(1, 0), Coordinates.of(1, 4));
        LinearVent linearVent = new LinearVent(Coordinates.of(1, 2), Coordinates.of(2, 3));
        List<Coordinates> crossPoints = verticalVent.calculateCrossPointCoordinates(linearVent);
        assertEquals(crossPoints, linearVent.calculateCrossPointCoordinates(verticalVent));
        assertEquals(1, crossPoints.size());
        assertTrue(crossPoints.contains(Coordinates.of(1, 2)));
    }

}