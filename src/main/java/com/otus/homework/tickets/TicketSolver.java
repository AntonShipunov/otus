package com.otus.homework.tickets;

public class TicketSolver {

    public static long calc(int n) {
        long[] sum = calcSum(n);
        long result = 0;
        for (long i : sum) {
            result += i * i;
        }
        return result;
    }

    private static long[] calcSum(int n) {
        if (n == 0) return new long[]{1};
        int maxSum = 9 * n;
        long[] sum = new long[maxSum + 1];
        long[] previous = calcSum(n - 1);
        for (int i = 0; i < sum.length; i++) {
            for (int j = 0; j <= 9; j++) {
                if (i >= j && (i - j) < previous.length) {
                    sum[i] += previous[i - j];
                }
            }
        }
        return sum;
    }
}
