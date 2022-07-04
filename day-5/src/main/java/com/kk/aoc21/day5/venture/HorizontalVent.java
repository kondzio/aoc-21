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
public class HorizontalVent extends AbstractVent {
    private final int y;

    public HorizontalVent(Coordinates begin, Coordinates end) {
        super(begin, end);
        y = begin.getY();
    }

    @Override
    public List<Coordinates> calculateCrossPointCoordinates(LinearVent linearVent) {
        int crossY = this.getY();
        int crossX = (crossY - linearVent.getB()) / linearVent.getA();
        Coordinates crossCoordinates = Coordinates.of(crossX, crossY);
        if (this.isOverlapping(crossCoordinates) && linearVent.isOverlapping(crossCoordinates)) {
            return singletonList(crossCoordinates);
        }
        return emptyList();
    }

    @Override
    public List<Coordinates> calculateCrossPointCoordinates(HorizontalVent horizontalVent) {
        final Coordinates thisMinX = min(Coordinates::getX, this.getBegin(), this.getEnd());
        final Coordinates thisMaxX = max(Coordinates::getX, this.getBegin(), this.getEnd());
        final Coordinates otherMinX = min(Coordinates::getX, horizontalVent.getBegin(), horizontalVent.getEnd());
        final Coordinates otherMaxX = max(Coordinates::getX, horizontalVent.getBegin(), horizontalVent.getEnd());

        int from = 0;
        int to = -1;
        if (this.isOverlapping(otherMinX) || horizontalVent.isOverlapping(thisMinX)) {
            from = Math.max(thisMinX.getX(), otherMinX.getX());
            to = Math.min(thisMaxX.getX(), otherMaxX.getX());
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
