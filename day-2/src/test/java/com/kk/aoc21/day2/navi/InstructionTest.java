package com.kk.aoc21.day2.navi;

import com.kk.aoc21.utils.InputFileLoadUtils;
import org.junit.jupiter.api.Test;

import java.util.List;

class InstructionTest {

    @Test
    void test() {
        List<String> inputSteps = InputFileLoadUtils.readLines("test.txt");
        Position position = Instruction.compile(inputSteps).execute(Position.of(0, 0));
        System.err.println(position);
    }

}