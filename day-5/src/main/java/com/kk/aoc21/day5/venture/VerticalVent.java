package com.kk.aoc21.day5.venture;

import com.kk.aoc21.day5.utils.LineUtils;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

@Getter
public class VerticalVent extends AbstractVent {
    private final int x;

    public VerticalVent(Coordinates begin, Coordinates end) {
        super(begin, end);
        x = begin.getX();
    }

    @Override
    public List<Coordinates> calculateCrossPointCoordinates(VerticalVent verticalVent) {
        if(this.getX() != verticalVent.getX()) {
            return emptyList();
        }
        int thisMinY = Math.min(this.getBegin().getY(), this.getEnd().getY());
        int thisMaxY = Math.max(this.getBegin().getY(), this.getEnd().getY());
        int otherMinY = Math.min(verticalVent.getBegin().getY(), verticalVent.getEnd().getY());
        int otherMaxY = Math.max(verticalVent.getBegin().getY(), verticalVent.getEnd().getY());

        int from = 0;
        int to = 0;
        if (thisMinY <= otherMinY && thisMaxY >= otherMinY) {
            from = otherMinY;
            to = Math.min(thisMaxY, otherMaxY);
        } else if (thisMinY >= otherMinY && otherMaxY >= thisMinY) {
            from = thisMinY;
            to = Math.min(thisMaxY, otherMaxY);
        }
        List<Coordinates> coordinates = new ArrayList<>();
        for (int i = from; i < to + 1; i++) {
            coordinates.add(Coordinates.of(getX(), i));
        }
        return coordinates;
    }

    @Override
    public List<Coordinates> calculateCrossPointCoordinates(LinearVent linearVent) {
        int crossX = getX();
        int crossY = linearVent.getA() * crossX + linearVent.getB();
        Coordinates crossCoordinates = Coordinates.of(crossX, crossY);
        if (this.isOverlapping(crossCoordinates) && linearVent.isOverlapping(crossCoordinates)) {
            return singletonList(crossCoordinates);
        }
        return emptyList();
    }

    @Override
    public List<Coordinates> calculateCrossPointCoordinates(HorizontalVent horizontalVent) {
        int crossX = this.getX();
        int crossY = horizontalVent.getY();
        Coordinates crossCoordinates = Coordinates.of(crossX, crossY);
        if (this.isOverlapping(crossCoordinates) && horizontalVent.isOverlapping(crossCoordinates)) {
            return singletonList(crossCoordinates);
        }
        return emptyList();
    }

    @Override
    public boolean isOverlapping(Coordinates coordinates) {
        return coordinates.getX() == getX() && LineUtils.isBetween(getBegin().getY(), getEnd().getY(), coordinates.getY());
    }

    @Override
    public VentType getType() {
        return VentType.VERTICAL;
    }
}
