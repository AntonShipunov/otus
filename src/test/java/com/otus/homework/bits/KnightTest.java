package com.otus.homework.bits;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KnightTest {

    @ParameterizedTest
    @MethodSource("getData")
    void testMoves(String in, String count, String value) {
        int position = Integer.parseInt(in);
        int expectedCount = Integer.parseInt(count);
        long expectedMoves = Long.parseUnsignedLong(value);
        Knight knight = new Knight();
        long actualMoves = knight.moves(position);
        int actualCount = knight.countMoves(actualMoves);
        assertEquals(expectedCount, actualCount);
        assertEquals(expectedMoves, actualMoves);
    }

    static Stream<Arguments> getData() throws IOException {
        Stream.Builder<Arguments> builder = Stream.builder();
        for (int i = 0; i < 10; i++) {
            String inputFile = String.format("bitboard/knight/test.%d.in", i);
            String in = readLines(inputFile).get(0);
            String outputFile = String.format("bitboard/knight/test.%d.out", i);
            List<String> out = readLines(outputFile);
            builder.add(Arguments.of(in, out.get(0), out.get(1)));
        }
        return builder.build();
    }

    private static List<String> readLines(String filePath) throws IOException {
        return Files.readAllLines(Paths.get("src/test/resources", filePath));
    }
}
