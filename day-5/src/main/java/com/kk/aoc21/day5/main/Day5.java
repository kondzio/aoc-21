package com.kk.aoc21.day5.main;

import com.kk.aoc21.day5.calculator.VentCrossingCalculator;
import com.kk.aoc21.day5.parser.VentParser;
import com.kk.aoc21.day5.venture.VentType;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class Day5 {
    public static void main(String[] args) {
        day5part2();
    }

    private static void day5part1() {
        VentCrossingCalculator crossingCalculator = new VentCrossingCalculator();
        Collection<VentCrossingCalculator.CrossPoint> crossPoints = crossingCalculator.calculateAllCrossPoints(VentParser.parseVents("input.txt").stream().filter(vent -> Arrays.asList(VentType.VERTICAL, VentType.HORIZONTAL).contains(vent.getType())).collect(Collectors.toList()));
        System.err.println(crossPoints.size());
    }

    private static void day5part2() {
        VentCrossingCalculator crossingCalculator = new VentCrossingCalculator();
        Collection<VentCrossingCalculator.CrossPoint> crossPoints = crossingCalculator.calculateAllCrossPoints(VentParser.parseVents("input.txt"));
        System.err.println(crossPoints.size());
    }
}
