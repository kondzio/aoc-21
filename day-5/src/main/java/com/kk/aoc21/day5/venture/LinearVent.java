package com.kk.aoc21.day5.venture;

import lombok.Getter;
import lombok.NonNull;

import java.util.List;

import static com.kk.aoc21.day5.utils.LineUtils.isBetween;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

@Getter
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
        //TODO czy rozwazyles ze te linie moga sie pokrywac? chyba nie rozwazyles...
        int crossX = (this.getB() - linearVent.getB()) / (linearVent.getA() - this.getA());
        int crossY = this.getA() * crossX + this.getB();
        Coordinates crossCoordinates = Coordinates.of(crossX, crossY);
        if (this.isOverlapping(crossCoordinates) && linearVent.isOverlapping(crossCoordinates)) {
            return singletonList(crossCoordinates);
        }
        return emptyList();
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
        int crossX = -1 * this.getB() / this.getA();
        Coordinates crossCoordinates = Coordinates.of(crossX, crossY);
        if (this.isOverlapping(crossCoordinates) && horizontalVent.isOverlapping(crossCoordinates)) {
            return singletonList(crossCoordinates);
        }
        return emptyList();
    }

    @Override
    public boolean isOverlapping(@NonNull Coordinates coordinates) {
        if ((getA() * coordinates.getX() + getB()) == coordinates.getY()) {
            return isBetween(getBegin().getX(), getEnd().getX(), coordinates.getX()) && isBetween(getBegin().getY(), getEnd().getX(), coordinates.getY());
        }
        return false;
    }

    @Override
    public VentType getType() {
        return VentType.LINEAR;
    }
}

