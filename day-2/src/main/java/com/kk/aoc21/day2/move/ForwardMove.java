package com.kk.aoc21.day2.move;

import com.kk.aoc21.day2.navi.Position;

public class ForwardMove extends Move {

    public ForwardMove(int speed) {
        super(Direction.FORWARD, speed);
    }

    @Override
    public Position make(Position currPos) {
        return Position.of(currPos.getHorizontal() + getSpeed(), currPos.getDepth());
    }
}
