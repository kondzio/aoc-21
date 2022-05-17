package com.kk.aoc21.day2.move.aim;

import com.kk.aoc21.day2.move.Direction;
import com.kk.aoc21.day2.move.Move;
import com.kk.aoc21.day2.move.MoveFactory;
import com.kk.aoc21.day2.move.base.BaseDownMove;
import com.kk.aoc21.day2.move.base.BaseForwardMove;
import com.kk.aoc21.day2.move.base.BaseUpMove;
import com.kk.aoc21.day2.navi.AimPosition;
import com.kk.aoc21.day2.navi.BasePosition;
import lombok.NonNull;

public class AimMoveFactory implements MoveFactory<AimPosition> {

    @Override
    public Move<AimPosition> createMove(@NonNull String inputStep) {
        String[] tokens = inputStep.split(" ");
        Direction direction = Direction.getByLiteral(tokens[0]).orElseThrow(() -> new IllegalArgumentException("Unsupported move"));
        int speed = Integer.parseInt(tokens[1]);
        switch (direction) {
            case DOWN:
                return new AimDownMove(speed);
            case UP:
                return new AimUpMove(speed);
            case FORWARD:
                return new AimForwardMove(speed);
        }
        throw new IllegalStateException("This line should not be reached");
    }
}
