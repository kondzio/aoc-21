package com.kk.aoc21.day5.parser;

import com.kk.aoc21.day5.venture.*;
import com.kk.aoc21.utils.InputFileLoadUtils;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class VentParser {

    public static List<Vent> parseVents(@NonNull String fileName) {
        List<Vent> vents = new ArrayList<>();
        List<String> lines = InputFileLoadUtils.readLines(fileName);
        for (String line : lines) {
            String[] endTokens = line.split(" -> ");
            String[] firstEndTokens = endTokens[0].split(",");
            String[] secondEndTokens = endTokens[1].split(",");
            Coordinates firstEnd = Coordinates.of(Integer.parseInt(firstEndTokens[0]), Integer.parseInt(firstEndTokens[1]));
            Coordinates secondEnd = Coordinates.of(Integer.parseInt(secondEndTokens[0]), Integer.parseInt(secondEndTokens[1]));
            if (firstEnd.getX() == secondEnd.getX()) {
                vents.add(new VerticalVent(firstEnd, secondEnd));
            } else if (firstEnd.getY() == secondEnd.getY()) {
                vents.add(new HorizontalVent(firstEnd, secondEnd));
            } else {
                vents.add(new LinearVent(firstEnd, secondEnd));
            }
        }
        return vents;
    }

}
