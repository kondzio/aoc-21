package com.kk.aoc21.day2.move.aim;

import com.kk.aoc21.day2.move.Direction;
import com.kk.aoc21.day2.move.Move;
import com.kk.aoc21.day2.navi.AimPosition;

public class AimUpMove extends Move<AimPosition> {
    public AimUpMove(int speed) {
        super(Direction.UP, speed);
    }

    @Override
    public AimPosition make(AimPosition position) {
        return AimPosition.of(position.getHorizontal(), position.getDepth(), position.getAim() - getSpeed());

    }
}
