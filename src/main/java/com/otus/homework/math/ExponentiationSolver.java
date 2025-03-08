package com.otus.homework.math;

public class ExponentiationSolver {

    //пункт 1
    public static double powN(double v, long n) {
        double res = 1;
        for (int i = 0; i < n; i++) {
            res = res * v;
        }
        return res;
    }

    //пункт 11
    public static double powLogN(double v, long n) {
        if (n == 0) return 1;
        double half  = powLogN(v, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * v;
        }
    }
}
