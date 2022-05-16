package com.kk.aoc21.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.SneakyThrows;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InputFileLoadUtils {

    @SneakyThrows
    public static List<String> readLines(@NonNull String fileName) {
        URL url = InputFileLoadUtils.class.getClassLoader().getResource(fileName);
        return Files.readAllLines(Path.of(Objects.requireNonNull(url).toURI()));
    }
}
