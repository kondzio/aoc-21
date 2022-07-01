package com.kk.aoc21.day5.calculator;

import com.kk.aoc21.day5.parser.VentParser;
import com.kk.aoc21.day5.venture.Coordinates;
import com.kk.aoc21.day5.venture.HorizontalVent;
import com.kk.aoc21.day5.venture.VentType;
import com.kk.aoc21.day5.venture.VerticalVent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VentCrossingCalculatorTest {
    @Test
    void baseTest() {
        VentCrossingCalculator crossingCalculator = new VentCrossingCalculator();
        Collection<VentCrossingCalculator.CrossPoint> crossPoints = crossingCalculator.calculateAllCrossPoints(VentParser.parseVents("test.txt").stream().filter(vent -> Arrays.asList(VentType.VERTICAL, VentType.HORIZONTAL).contains(vent.getType())).collect(Collectors.toList()));
        assertEquals(5, crossPoints.size());
    }


    @Test
    void multipleOverlaps() {
        VentCrossingCalculator crossingCalculator = new VentCrossingCalculator();
        Collection<VentCrossingCalculator.CrossPoint> crossPoints = crossingCalculator.calculateAllCrossPoints(Arrays.asList(
                new VerticalVent(Coordinates.of(0, -2), Coordinates.of(0, 2)),
                new VerticalVent(Coordinates.of(0, 0), Coordinates.of(0, 0)),
                new HorizontalVent(Coordinates.of(-2, 0), Coordinates.of(2, 0)),
                new HorizontalVent(Coordinates.of(0, 0), Coordinates.of(0, 0))));
        assertEquals(1, crossPoints.size());
        assertEquals(4, crossPoints.stream().findFirst().map(crossPoint -> crossPoint.getCrossingVents().size()).orElseGet(() -> Assertions.fail("No crossing point found")));
    }
}