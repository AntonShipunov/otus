package com.otus.homework.tickets;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicketSolverTest {

    @ParameterizedTest
    @MethodSource("getData")
    void testTicketsCalc(String in, String out) {
        int n = Integer.parseInt(in);
        long expected = Long.parseLong(out);
        long actual = TicketSolver.calc(n);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> getData() throws IOException {
        Stream.Builder<Arguments> builder = Stream.builder();
        for (int i = 0; i < 10; i++) {
            String inputFile = String.format("tickets/test.%d.in", i);
            String in = readLine(inputFile);
            String outputFile = String.format("tickets/test.%d.out", i);
            String out = readLine(outputFile);
            builder.add(Arguments.of(in, out));
        }
        return builder.build();
    }

    private static String readLine(String filePath) throws IOException {
        return Files.readAllLines(Paths.get("src/test/resources", filePath)).get(0);
    }
}
