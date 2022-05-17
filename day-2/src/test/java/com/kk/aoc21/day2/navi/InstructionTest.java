package com.kk.aoc21.day2.navi;

import com.kk.aoc21.day2.move.base.BaseMoveFactory;
import com.kk.aoc21.utils.InputFileLoadUtils;
import org.junit.jupiter.api.Test;

import java.util.List;

class InstructionTest {

    @Test
    void baseMovesTest() {
        List<String> inputSteps = InputFileLoadUtils.readLines("test.txt");
        BasePosition position = Instruction.compile(inputSteps, new BaseMoveFactory()).execute(BasePosition.of(0, 0));
        System.err.println(position);
    }

}