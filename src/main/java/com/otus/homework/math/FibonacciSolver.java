package com.otus.homework.math;

import java.math.BigInteger;

public class FibonacciSolver {

    //пункт 2
    public static BigInteger calcIterative(int n) {
        if (n == 0) return BigInteger.ZERO;
        BigInteger a1 = BigInteger.ONE;
        BigInteger a2 = BigInteger.ONE;
        BigInteger current = BigInteger.ONE;
        for (int i = 2; i < n; i++) {
            current = a1.add(a2);
            a1 = a2;
            a2 = current;
        }
        return current;
    }

    //пункт 2
    public static BigInteger calcRecursive(int n) {
        if (n == 0) return BigInteger.ZERO;
        if (n <= 2) return BigInteger.ONE;
        return calcRecursive(n - 1).add(calcRecursive(n - 2));
    }

    //пункт 13
    public static long calcGoldenRatio(int n) {
        double ratio = (1 + Math.sqrt(5)) / 2.0;
        return (long) Math.floor(Math.pow(ratio, n) / Math.sqrt(5) + 0.5);
    }
}
