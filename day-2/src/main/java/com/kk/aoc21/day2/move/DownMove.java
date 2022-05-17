package com.kk.aoc21.day2.move;

import com.kk.aoc21.day2.navi.Position;

public class DownMove extends Move {
    public DownMove(int speed) {
        super(Direction.DOWN, speed);
    }

    @Override
    public Position make(Position position) {
        return Position.of(position.getHorizontal(), position.getDepth() + getSpeed());
    }
}
