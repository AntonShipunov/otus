package com.otus.homework.sort;

import com.otus.homework.helper.SortHelper;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ShellHibbardSortTest {

    @ParameterizedTest
    @MethodSource("getRandom")
    void testRandom(String in, String out) {
        test(in, out);
    }

    @ParameterizedTest
    @MethodSource("getDigits")
    void testDigits(String in, String out) {
        test(in, out);
    }

    @ParameterizedTest
    @MethodSource("getRevers")
    void testRevers(String in, String out) {
        test(in, out);
    }

    @ParameterizedTest
    @MethodSource("getSorted")
    void testSorted(String in, String out) {
        test(in, out);
    }

    private void test(String in, String out) {
        int[] input = SortHelper.toArray(in);
        int[] expected = SortHelper.toArray(out);
        long start = System.currentTimeMillis();
        int[] actual = ShellSort.hibbardSort(input);
        System.out.println(input.length + ": " + (System.currentTimeMillis() - start));
        assertArrayEquals(expected, actual);
    }

    private static Stream<Arguments> getRandom() throws IOException {
        return SortHelper.getData("random");
    }

    private static Stream<Arguments> getDigits() throws IOException {
        return SortHelper.getData("digits");
    }

    private static Stream<Arguments> getRevers() throws IOException {
        return SortHelper.getData("revers");
    }

    private static Stream<Arguments> getSorted() throws IOException {
        return SortHelper.getData("sorted");
    }
}
