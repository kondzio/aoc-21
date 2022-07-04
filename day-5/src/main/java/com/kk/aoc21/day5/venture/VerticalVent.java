package com.kk.aoc21.day5.venture;

import com.kk.aoc21.day5.utils.LineUtils;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

import static com.kk.aoc21.day5.utils.LineUtils.max;
import static com.kk.aoc21.day5.utils.LineUtils.min;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

@Getter
@EqualsAndHashCode(callSuper = true)
public class VerticalVent extends AbstractVent {
    private final int x;
    public VerticalVent(Coordinates begin, Coordinates end) {
        super(begin, end);
        x = begin.getX();
    }

    @Override
    public List<Coordinates> calculateCrossPointCoordinates(VerticalVent verticalVent) {
        final Coordinates thisMinY = min(Coordinates::getY, this.getBegin(), this.getEnd());
        final Coordinates thisMaxY = max(Coordinates::getY, this.getBegin(), this.getEnd());
        final Coordinates otherMinY = min(Coordinates::getY, verticalVent.getBegin(), verticalVent.getEnd());
        final Coordinates otherMaxY = max(Coordinates::getY, verticalVent.getBegin(), verticalVent.getEnd());
        int from = 0;
        int to = -1;
        if (this.isOverlapping(otherMinY) || verticalVent.isOverlapping(thisMinY)) {
            from = Math.max(thisMinY.getY(), otherMinY.getY());
            to = Math.min(thisMaxY.getY(), otherMaxY.getY());
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
