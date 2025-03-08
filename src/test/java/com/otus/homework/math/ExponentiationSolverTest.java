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

public class ExponentiationSolverTest {

    @ParameterizedTest
    @MethodSource("getData")
    void testPowN(String num, String power, String out) {
        double value = Double.parseDouble(num);
        long pow = Long.parseLong(power);
        double expected =  Double.parseDouble(out);
        long start = System.currentTimeMillis();
        double actual = ExponentiationSolver.powN(value, pow);
        System.out.println("time: " + (System.currentTimeMillis() - start));
        assertEquals(expected, actual, 1e-5);
    }

    @ParameterizedTest
    @MethodSource("getData")
    void testPowLogN(String num, String power, String out) {
        double value = Double.parseDouble(num);
        long pow = Long.parseLong(power);
        double expected =  Double.parseDouble(out);
        long start = System.currentTimeMillis();
        double actual = ExponentiationSolver.powLogN(value, pow);
        System.out.println("time: " + (System.currentTimeMillis() - start));
        assertEquals(expected, actual, 1e-5);
    }

    static Stream<Arguments> getData() throws IOException {
        Stream.Builder<Arguments> builder = Stream.builder();
        for (int i = 0; i < 10; i++) {
            String inputFile = String.format("power/test.%d.in", i);
            List<String> in = readLines(inputFile);
            String outputFile = String.format("power/test.%d.out", i);
            String out = readLines(outputFile).get(0);
            builder.add(Arguments.of(in.get(0), in.get(1), out));
        }
        return builder.build();
    }

    private static List<String> readLines(String filePath) throws IOException {
        return Files.readAllLines(Paths.get("src/test/resources", filePath));
    }
}
