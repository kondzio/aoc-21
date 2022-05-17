package com.kk.aoc21.day2.move.base;

import com.kk.aoc21.day2.move.*;
import com.kk.aoc21.day2.navi.BasePosition;
import lombok.NonNull;

public class BaseMoveFactory implements MoveFactory<BasePosition> {

    @Override
    public Move<BasePosition> createMove(@NonNull String inputStep) {
        String[] tokens = inputStep.split(" ");
        Direction direction = Direction.getByLiteral(tokens[0]).orElseThrow(() -> new IllegalArgumentException("Unsupported move"));
        int speed = Integer.parseInt(tokens[1]);
        switch (direction) {
            case DOWN:
                return new BaseDownMove(speed);
            case UP:
                return new BaseUpMove(speed);
            case FORWARD:
                return new BaseForwardMove(speed);
        }
        throw new IllegalStateException("This line should not be reached");
    }
}
