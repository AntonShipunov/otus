package com.otus.homework.math;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciSolverTest {

    @ParameterizedTest
    @MethodSource("getData")
    void testIterativeCalc(String in, String out) {
        int n = Integer.parseInt(in);
        BigInteger expected = new  BigInteger(out);
        long start = System.currentTimeMillis();
        BigInteger actual = FibonacciSolver.calcIterative(n);
        System.out.println("time: " + (System.currentTimeMillis() - start));
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("getData")
    void testRecursiveCalc(String in, String out) {
        int n = Integer.parseInt(in);
        BigInteger expected = new  BigInteger(out);
        long start = System.currentTimeMillis();
        BigInteger actual = FibonacciSolver.calcRecursive(n);
        System.out.println("time: " + (System.currentTimeMillis() - start));
        assertEquals(expected, actual);
    }

    static Stream<Arguments> getData() throws IOException {
        Stream.Builder<Arguments> builder = Stream.builder();
        for (int i = 0; i < 13; i++) {
            String inputFile = String.format("fibo/test.%d.in", i);
            String in = readLines(inputFile).get(0);
            String outputFile = String.format("fibo/test.%d.out", i);
            String out = readLines(outputFile).get(0);
            builder.add(Arguments.of(in, out));
        }
        return builder.build();
    }

    private static List<String> readLines(String filePath) throws IOException {
        return Files.readAllLines(Paths.get("src/test/resources", filePath));
    }
}
