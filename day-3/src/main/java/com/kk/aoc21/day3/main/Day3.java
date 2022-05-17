package com.kk.aoc21.day3.main;

import com.kk.aoc21.day3.power.calculator.GammaRateCalculator;
import com.kk.aoc21.day3.power.calculator.PowerConsumptionCalculator;
import com.kk.aoc21.utils.InputFileLoadUtils;

public class Day3 {
    public static void main(String[] args) {
        calculatePart1();
    }

    private static void calculatePart1() {
       PowerConsumptionCalculator powerConsumptionCalculator = new PowerConsumptionCalculator(new GammaRateCalculator());
        System.err.println(powerConsumptionCalculator.calculate(InputFileLoadUtils.readLines("input.txt")));
    }
}
