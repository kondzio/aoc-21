package com.kk.aoc21.day2.move.base;

import com.kk.aoc21.day2.move.Direction;
import com.kk.aoc21.day2.move.Move;
import com.kk.aoc21.day2.navi.BasePosition;

public class BaseForwardMove extends Move<BasePosition> {

    public BaseForwardMove(int speed) {
        super(Direction.FORWARD, speed);
    }

    @Override
    public BasePosition make(BasePosition currPos) {
        return BasePosition.of(currPos.getHorizontal() + getSpeed(), currPos.getDepth());
    }
}
