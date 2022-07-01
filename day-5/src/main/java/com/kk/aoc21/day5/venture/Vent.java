package com.kk.aoc21.day5.venture;

import java.util.List;

public interface Vent {
    Coordinates getBegin();

    Coordinates getEnd();

    boolean isOverlapping(Coordinates coordinates);

    List<Coordinates> calculateCrossPointCoordinates(LinearVent linearVent);

    List<Coordinates> calculateCrossPointCoordinates(HorizontalVent horizontalVent);

    List<Coordinates> calculateCrossPointCoordinates(VerticalVent verticalVent);

    List<Coordinates> calculateCrossPointCoordinates(Vent vent);

    int getId();

    VentType getType();
}
