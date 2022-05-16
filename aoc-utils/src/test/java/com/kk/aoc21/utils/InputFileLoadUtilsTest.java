package com.kk.aoc21.utils;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputFileLoadUtilsTest {

    @Test
    void baseTest() {
        List<String> lines = InputFileLoadUtils.readLines("test.txt");
        assertEquals(List.of("H", "W", "D", "P"), lines);
    }
}
