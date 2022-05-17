package com.kk.aoc21.day2.move;

import lombok.NonNull;

public class MoveFactory {

    public Move createMove(@NonNull String inputStep) {
        String[] tokens = inputStep.split(" ");
        Direction direction = Direction.getByLiteral(tokens[0]).orElseThrow(() -> new IllegalArgumentException("Unsupported move"));
        int speed = Integer.parseInt(tokens[1]);
        switch (direction) {
            case DOWN:
                return new DownMove(speed);
            case UP:
                return new UpMove(speed);
            case FORWARD:
                return new ForwardMove(speed);
        }
        throw new IllegalStateException("This places should not be reached");
    }
}
