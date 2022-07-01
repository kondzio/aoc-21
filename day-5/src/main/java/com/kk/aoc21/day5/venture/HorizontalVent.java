package com.kk.aoc21.day5.venture;

import com.kk.aoc21.day5.utils.LineUtils;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

@Getter
public class HorizontalVent extends AbstractVent {
    private final int y;

    public HorizontalVent(Coordinates begin, Coordinates end) {
        super(begin, end);
        y = begin.getY();
    }

    @Override
    public List<Coordinates> calculateCrossPointCoordinates(LinearVent linearVent) {
        int crossY = this.getY();
        int crossX = -1 * linearVent.getB() / linearVent.getA();
        Coordinates crossCoordinates = Coordinates.of(crossX, crossY);
        if (this.isOverlapping(crossCoordinates) && linearVent.isOverlapping(crossCoordinates)) {
            return singletonList(crossCoordinates);
        }
        return emptyList();
    }

    @Override
    public List<Coordinates> calculateCrossPointCoordinates(HorizontalVent horizontalVent) {
        if(this.getY() != horizontalVent.getY()) {
            return emptyList();
        }
        int thisMinX = Math.min(this.getBegin().getX(), this.getEnd().getX());
        int thisMaxX = Math.max(this.getBegin().getX(), this.getEnd().getX());
        int otherMinX = Math.min(horizontalVent.getBegin().getX(), horizontalVent.getEnd().getX());
        int otherMaxX = Math.max(horizontalVent.getBegin().getX(), horizontalVent.getEnd().getX());

        int from = 0;
        int to = 0;
        if (thisMinX <= otherMinX && thisMaxX >= otherMinX) {
            from = otherMinX;
            to = Math.min(thisMaxX, otherMaxX);
        } else if (thisMinX >= otherMinX && otherMaxX >= thisMinX) {
            from = thisMinX;
            to = Math.min(thisMaxX, otherMaxX);
        }
        List<Coordinates> coordinates = new ArrayList<>();
        for (int i = from; i < to + 1; i++) {
            coordinates.add(Coordinates.of(i, getY()));
        }
        return coordinates;
    }

    @Override
    public List<Coordinates> calculateCrossPointCoordinates(VerticalVent verticalVent) {
        int crossX = verticalVent.getBegin().getX();
        int crossY = this.getBegin().getY();
        Coordinates crossCoordinates = Coordinates.of(crossX, crossY);
        if (this.isOverlapping(crossCoordinates) && verticalVent.isOverlapping(crossCoordinates)) {
            return singletonList(crossCoordinates);
        }
        return emptyList();
    }

    @Override
    public boolean isOverlapping(Coordinates coordinates) {
        return coordinates.getY() == getY() && LineUtils.isBetween(getBegin().getX(), getEnd().getX(), coordinates.getX());
    }

    @Override
    public VentType getType() {
        return VentType.HORIZONTAL;
    }
}
