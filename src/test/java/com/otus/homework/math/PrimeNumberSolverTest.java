package com.otus.homework.math;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrimeNumberSolverTest {

    @ParameterizedTest
    @MethodSource("getData")
    void testCalcPrimes(String in, String out) {
        int n = Integer.parseInt(in);
        int expected =  Integer.parseInt(out);
        long start = System.currentTimeMillis();
        double actual = PrimeNumberSolver.calcPrimes(n);
        System.out.println("time: " + (System.currentTimeMillis() - start));
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("getData")
    void testOptimizedCalcPrimes(String in, String out) {
        int n = Integer.parseInt(in);
        int expected =  Integer.parseInt(out);
        long start = System.currentTimeMillis();
        double actual = PrimeNumberSolver.optimizedCalcPrimes(n);
        System.out.println("time: " + (System.currentTimeMillis() - start));
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("getData")
    void testCalcEratosthene(String in, String out) {
        int n = Integer.parseInt(in);
        int expected =  Integer.parseInt(out);
        long start = System.currentTimeMillis();
        double actual = PrimeNumberSolver.calcEratosthene(n);
        System.out.println("time: " + (System.currentTimeMillis() - start));
        assertEquals(expected, actual);
    }

    static Stream<Arguments> getData() throws IOException {
        Stream.Builder<Arguments> builder = Stream.builder();
        for (int i = 0; i < 15; i++) {
            String inputFile = String.format("primes/test.%d.in", i);
            String in = readLines(inputFile).get(0);
            String outputFile = String.format("primes/test.%d.out", i);
            String out = readLines(outputFile).get(0);
            builder.add(Arguments.of(in, out));
        }
        return builder.build();
    }

    private static List<String> readLines(String filePath) throws IOException {
        return Files.readAllLines(Paths.get("src/test/resources", filePath));
    }
}
