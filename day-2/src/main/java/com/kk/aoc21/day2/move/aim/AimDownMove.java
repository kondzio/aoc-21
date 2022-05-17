package com.kk.aoc21.day2.move.aim;

import com.kk.aoc21.day2.move.Direction;
import com.kk.aoc21.day2.move.Move;
import com.kk.aoc21.day2.navi.AimPosition;
import lombok.NonNull;

public class AimDownMove extends Move<AimPosition> {
    public AimDownMove(int speed) {
        super(Direction.DOWN, speed);
    }

    @Override
    public AimPosition make(AimPosition position) {
        return AimPosition.of(position.getHorizontal(), position.getDepth(), position.getAim() + getSpeed());
    }
}
