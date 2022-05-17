package com.kk.aoc21.day2.navi;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class AimPosition extends BasePosition {
    private final int aim;

    public AimPosition(int horizontal, int depth, int aim) {
        super(horizontal, depth);
        this.aim = aim;
    }

    public static AimPosition of(int horizontal, int depth, int aim) {
        return new AimPosition(horizontal, depth, aim);
    }
}
