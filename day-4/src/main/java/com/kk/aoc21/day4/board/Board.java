package com.kk.aoc21.day4.board;

import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Board {
    private final List<Line<Integer>> rows = new ArrayList<>();
    private final List<Line<Integer>> columns = new ArrayList<>();
    private Integer winLiteral;

    @Getter
    private boolean win;

    public boolean cross(@NonNull Integer literal) {
        rows.forEach(row -> row.cross(literal));

        win = rows.stream().filter(Line::isCrossed).findFirst().map(line -> true).orElseGet(() -> columns.stream().anyMatch(Line::isCrossed));
        if (win) {
            winLiteral = literal;
        }
        return win;
    }

    public Board addRow(@NonNull Line<Integer> line) {
        rows.add(line);
        if (columns.isEmpty()) {
            line.getLiterals().forEach(literal -> columns.add(Line.of()));
        }
        for (int i = 0; i < line.getLiterals().size(); i++) {
            columns.get(i).addLiteral(line.getLiterals().get(i));
        }
        return this;
    }

    public int score() {
        return winLiteral * rows.stream().map(row -> row.getLiterals().stream().filter(literal -> !literal.isCrossed()).map(Literal::getValue).reduce(0, Integer::sum)).reduce(0, Integer::sum);
    }

    public void print() {
        System.err.println("\n");
        rows.forEach(line -> System.err.println(line.getLiterals().stream().map(this::decorate).collect(Collectors.joining("\t"))));
    }

    private String decorate(Literal<Integer> literal) {
        StringBuilder decorated = new StringBuilder();
        if (literal.isCrossed()) {
            decorated.append("#");
        }
        decorated.append(literal.getValue().toString());
        return decorated.toString();
    }

}
