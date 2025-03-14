package com.otus.homework.helper;

import org.junit.jupiter.params.provider.Arguments;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class SortHelper {

    public static int[] toArray(String str) {
        String[] arr = str.split(" ");
        return Arrays.stream(arr)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static Stream<Arguments> getData(String path) throws IOException {
        Stream.Builder<Arguments> builder = Stream.builder();
        for (int i = 0; i < 8; i++) {
            String inputFile = String.format("sort/" + path + "/test.%d.in", i);
            String in = readLines(inputFile).get(1);
            String outputFile = String.format("sort/" + path + "/test.%d.out", i);
            String out = readLines(outputFile).get(0);
            builder.add(Arguments.of(in, out));
        }
        return builder.build();
    }

    private static List<String> readLines(String filePath) throws IOException {
        return Files.readAllLines(Paths.get("src/test/resources", filePath));
    }
}
