package com.kk.aoc21.day2.move.base;

import com.kk.aoc21.day2.move.Direction;
import com.kk.aoc21.day2.move.Move;
import com.kk.aoc21.day2.navi.BasePosition;

public class BaseDownMove extends Move<BasePosition> {
    public BaseDownMove(int speed) {
        super(Direction.DOWN, speed);
    }

    @Override
    public BasePosition make(BasePosition position) {
        return BasePosition.of(position.getHorizontal(), position.getDepth() + getSpeed());
    }
}
