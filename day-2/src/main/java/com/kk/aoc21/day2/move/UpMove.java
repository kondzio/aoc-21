package com.kk.aoc21.day2.move;

import com.kk.aoc21.day2.navi.Position;

public class UpMove extends Move {
    public UpMove(int speed) {
        super(Direction.UP, speed);
    }

    @Override
    public Position make(Position position) {
        return Position.of(position.getHorizontal(), position.getDepth() - getSpeed());
    }
}
