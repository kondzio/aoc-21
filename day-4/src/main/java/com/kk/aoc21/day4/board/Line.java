package com.kk.aoc21.day4.board;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line<T> {
    private final List<Literal<T>> literals = new ArrayList<>();

    private Line(List<Literal<T>> literals) {
        this.literals.addAll(literals);
    }

    public Line<T> addLiteral(@NonNull Literal<T> literal) {
        literals.add(literal);
        return this;
    }

    public boolean isCrossed() {
        return literals.stream().allMatch(Literal::isCrossed);
    }

    public boolean cross(@NonNull T value) {
        return literals.stream().filter(literal -> literal.getValue().equals(value)).findAny().map(matching -> {
            matching.cross();
            return isCrossed();
        }).orElse(false);
    }

    public List<Literal<T>> getLiterals() {
        return Collections.unmodifiableList(literals);
    }

    public static <T> Line<T> of() {
        return new Line<>(new ArrayList<>());
    }

    public static <T> Line<T> of(@NonNull List<Literal<T>> literals) {
        return new Line<>(literals);
    }
}
