package com.kk.aoc21.day5.calculator;

import com.kk.aoc21.day5.parser.VentParser;
import com.kk.aoc21.day5.venture.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VentCrossingCalculatorTest {
    @Test
    void horizontalAndVerticalBaseTest() {
        VentCrossingCalculator crossingCalculator = new VentCrossingCalculator();
        Collection<VentCrossingCalculator.CrossPoint> crossPoints = crossingCalculator.calculateAllCrossPoints(VentParser.parseVents("test.txt").stream().filter(vent -> Arrays.asList(VentType.VERTICAL, VentType.HORIZONTAL).contains(vent.getType())).collect(Collectors.toList()));
        assertEquals(5, crossPoints.size());
    }

    @Test
    void linearBaseTest() {
        VentCrossingCalculator crossingCalculator = new VentCrossingCalculator();
        Collection<VentCrossingCalculator.CrossPoint> crossPoints = crossingCalculator.calculateAllCrossPoints(VentParser.parseVents("test.txt"));
        assertEquals(12, crossPoints.size());
        crossPoints.forEach(crossPoint -> System.err.printf("(%s, %s) -> %s%n", crossPoint.getPoint().getX(), crossPoint.getPoint().getY(), crossPoint.getCrossingCount()));
    }


    @Test
    void multipleOverlaps() {
        VentCrossingCalculator crossingCalculator = new VentCrossingCalculator();
        Collection<VentCrossingCalculator.CrossPoint> crossPoints = crossingCalculator.calculateAllCrossPoints(Arrays.asList(new VerticalVent(Coordinates.of(0, -2), Coordinates.of(0, 2)), new VerticalVent(Coordinates.of(0, 0), Coordinates.of(0, 0)), new HorizontalVent(Coordinates.of(-2, 0), Coordinates.of(2, 0)), new HorizontalVent(Coordinates.of(0, 0), Coordinates.of(0, 0))));
        assertEquals(1, crossPoints.size());
        assertEquals(4, crossPoints.stream().findFirst().map(crossPoint -> crossPoint.getCrossingVents().size()).orElseGet(() -> Assertions.fail("No crossing point found")));
    }

    @Test
    void threeCrossingVents() {
        VentCrossingCalculator crossingCalculator = new VentCrossingCalculator();
        Collection<VentCrossingCalculator.CrossPoint> points = crossingCalculator.calculateAllCrossPoints(Arrays.asList(
                new LinearVent(Coordinates.of(0, 0), Coordinates.of(3, 3)),
                new LinearVent(Coordinates.of(1, 3), Coordinates.of(3, 1)),
                new VerticalVent(Coordinates.of(2, 0), Coordinates.of(2, 3))));
        assertEquals(1, points.size());
        assertEquals(3, points.stream().findFirst().orElseGet(() -> Assertions.fail("No cross point present")).getCrossingVents().size());
    }
}