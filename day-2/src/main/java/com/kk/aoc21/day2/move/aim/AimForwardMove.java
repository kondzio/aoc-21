package com.kk.aoc21.day2.move.aim;

import com.kk.aoc21.day2.move.Direction;
import com.kk.aoc21.day2.move.Move;
import com.kk.aoc21.day2.navi.AimPosition;

public class AimForwardMove extends Move<AimPosition> {
    public AimForwardMove(int speed) {
        super(Direction.FORWARD, speed);
    }

    @Override
    public AimPosition make(AimPosition position) {
        return AimPosition.of(position.getHorizontal() + getSpeed(),
                position.getDepth() + position.getAim() * getSpeed(),
                position.getAim());
    }
}
