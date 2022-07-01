package com.kk.aoc21.day5.calculator;

import com.kk.aoc21.day5.venture.Coordinates;
import com.kk.aoc21.day5.venture.Vent;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.*;

public class VentCrossingCalculator {

    public Collection<CrossPoint> calculateAllCrossPoints(@NonNull List<Vent> vents) {
        Map<Coordinates, CrossPoint> crossPoints = new HashMap<>();
        for (int i = 0; i < vents.size(); i++) {
            Vent vent = vents.get(i);
            for (int j = i + 1; j < vents.size(); j++) {
                Vent otherVent = vents.get(j);
                vent.calculateCrossPointCoordinates(otherVent).forEach(coordinates -> {
                    CrossPoint crossPoint = crossPoints.get(coordinates);
                    if (crossPoint == null) {
                        crossPoint = CrossPoint.of(coordinates);
                        crossPoints.put(coordinates, crossPoint);
                    }
                    crossPoint.addCrossingVent(vent).addCrossingVent(otherVent);
                });
            }
        }
        return crossPoints.values();
    }

    @Getter
    @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
    public static class CrossPoint {
        @NonNull
        private final Coordinates point;
        private final Set<Vent> crossingVents = new HashSet<>();

        public int getCrossingCount() {
            return crossingVents.size();
        }

        public CrossPoint addCrossingVent(@NonNull Vent vent) {
            crossingVents.add(vent);
            return this;
        }

        public static CrossPoint of(@NonNull Coordinates point) {
            return new CrossPoint(point);
        }
    }
}
