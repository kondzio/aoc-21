package com.kk.aoc21.day2.main;

import com.kk.aoc21.day2.navi.Instruction;
import com.kk.aoc21.day2.navi.Position;
import com.kk.aoc21.utils.InputFileLoadUtils;

public class Day2 {

    public static void main(String[] args) {
        calculatePart1();
    }

    private static void calculatePart1() {
        Position currPos = Instruction.compile(InputFileLoadUtils.readLines("input.txt")).execute(Position.of(0, 0));
        System.err.println(currPos);
    }
}
