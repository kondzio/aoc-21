package com.kk.aoc21.day5.venture;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

import static com.kk.aoc21.day5.utils.LineUtils.*;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

@Getter
@EqualsAndHashCode(callSuper = true)
public class LinearVent extends AbstractVent {

    private final int a;
    private final int b;

    public LinearVent(@NonNull Coordinates begin, @NonNull Coordinates end) {
        super(begin, end);
        a = (end.getY() - begin.getY()) / (end.getX() - begin.getX());
        b = begin.getY() - a * begin.getX();
    }

    @Override
    public List<Coordinates> calculateCrossPointCoordinates(LinearVent linearVent) {
        if (this.getA() == linearVent.getA() && this.getB() == linearVent.getB()) {
            final Coordinates thisMinX = min(Coordinates::getX, this.getBegin(), this.getEnd());
            final Coordinates thisMaxX = max(Coordinates::getX, this.getBegin(), this.getEnd());
            final Coordinates otherMinX = min(Coordinates::getX, linearVent.getBegin(), linearVent.getEnd());
            final Coordinates otherMaxX = max(Coordinates::getX, linearVent.getBegin(), linearVent.getEnd());

            int from = 0;
            int to = -1;
            if (this.isOverlapping(otherMinX) || linearVent.isOverlapping(thisMinX)) {
                from = Math.max(thisMinX.getX(), otherMinX.getX());
                to = Math.min(thisMaxX.getX(), otherMaxX.getX());
            }
            List<Coordinates> coordinates = new ArrayList<>();
            for (int i = from; i < to + 1; i++) {
                coordinates.add(Coordinates.of(i, getA() * i + getB()));
            }
            return coordinates;
        } else {
            if (this.getA() == linearVent.getA()) {
                return emptyList();
            }
            int crossX = (linearVent.getB() - this.getB()) / (this.getA() - linearVent.getA());
            int crossY = this.getA() * crossX + this.getB();
            Coordinates crossCoordinates = Coordinates.of(crossX, crossY);
            if (this.isOverlapping(crossCoordinates) && linearVent.isOverlapping(crossCoordinates)) {
                return singletonList(crossCoordinates);
            }
            return emptyList();
        }
    }

    @Override
    public List<Coordinates> calculateCrossPointCoordinates(VerticalVent verticalVent) {
        int crossX = verticalVent.getX();
        int crossY = this.getA() * crossX + this.getB();
        Coordinates crossCoordinates = Coordinates.of(crossX, crossY);
        if (this.isOverlapping(crossCoordinates) && verticalVent.isOverlapping(crossCoordinates)) {
            return singletonList(crossCoordinates);
        }
        return emptyList();
    }

    @Override
    public List<Coordinates> calculateCrossPointCoordinates(HorizontalVent horizontalVent) {
        int crossY = horizontalVent.getY();
        int crossX = (crossY - this.getB()) / this.getA();
        Coordinates crossCoordinates = Coordinates.of(crossX, crossY);
        if (this.isOverlapping(crossCoordinates) && horizontalVent.isOverlapping(crossCoordinates)) {
            return singletonList(crossCoordinates);
        }
        return emptyList();
    }

    @Override
    public boolean isOverlapping(@NonNull Coordinates coordinates) {
        if ((getA() * coordinates.getX() + getB()) == coordinates.getY()) {
            return isBetween(getBegin().getX(), getEnd().getX(), coordinates.getX()) && isBetween(getBegin().getY(), getEnd().getY(), coordinates.getY());
        }
        return false;
    }

    @Override
    public VentType getType() {
        return VentType.LINEAR;
    }
}

