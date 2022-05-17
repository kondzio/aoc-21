package com.kk.aoc21.day2.navi;

import com.kk.aoc21.day2.move.aim.AimMoveFactory;
import com.kk.aoc21.day2.move.base.BaseMoveFactory;
import com.kk.aoc21.utils.InputFileLoadUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class InstructionTest {

    @Test
    void baseMovesTest() {
        List<String> inputSteps = InputFileLoadUtils.readLines("test.txt");
        BasePosition position = Instruction.compile(inputSteps, new BaseMoveFactory()).execute(BasePosition.of(0, 0));
        Assertions.assertEquals(15, position.getHorizontal());
        Assertions.assertEquals(10, position.getDepth());
    }

    @Test
    void aimMovesTest() {
        List<String> inputSteps = InputFileLoadUtils.readLines("test.txt");
        BasePosition position = Instruction.compile(inputSteps, new AimMoveFactory()).execute(AimPosition.of(0, 0, 0));
        Assertions.assertEquals(15, position.getHorizontal());
        Assertions.assertEquals(60, position.getDepth());
    }

}