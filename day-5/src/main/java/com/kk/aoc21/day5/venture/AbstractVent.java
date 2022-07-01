package com.kk.aoc21.day5.venture;

import lombok.Getter;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

import static com.kk.aoc21.day5.venture.VentType.*;

@Getter
public abstract class AbstractVent implements Vent {
    private static final AtomicInteger sequence = new AtomicInteger(0);
    private final int id = sequence.incrementAndGet();
    private final Coordinates begin;
    private final Coordinates end;

    protected AbstractVent(Coordinates begin, Coordinates end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    public List<Coordinates> calculateCrossPointCoordinates(Vent vent) {
        if (HORIZONTAL == vent.getType()) {
            return calculateCrossPointCoordinates((HorizontalVent) vent);
        } else if (VERTICAL == vent.getType()) {
            return calculateCrossPointCoordinates((VerticalVent) vent);
        } else if (LINEAR == vent.getType()) {
            return calculateCrossPointCoordinates((LinearVent) vent);
        } else {
            throw new IllegalStateException(String.format("Vent of type '%s' is not supported", vent.getClass().getSimpleName()));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractVent that = (AbstractVent) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
