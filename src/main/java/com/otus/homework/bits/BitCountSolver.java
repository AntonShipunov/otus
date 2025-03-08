package com.otus.homework.bits;

public class BitCountSolver {

    public static int calc1(int num) {
        int count = 0;
        while (num > 0) {
            if ((num & 0x01) > 0) {
                count++;
            }
            num = num >> 1;
        }
        return count;
    }

    public static int calc2(int num) {
        int count = 0;
        while (num > 0) {
            count++;
            num &= (num - 1);
        }
        return count;
    }
}
