package com.otus.homework.sort;

public class BubbleSort {

    public static int[] sort(int[] in) {
        for (int j = in.length - 1; j > 0; j--) {
            for (int i = 0; i < j; i++) {
                if (in[i] > in[i + 1]) {
                    int temp = in[i + 1];
                    in[i + 1] = in[i];
                    in[i] = temp;
                }
            }
        }
        return in;
    }

    public static int[] optimizedSort(int[] in) {
        boolean swapped;
        for (int j = in.length - 1; j > 0; j--) {
            swapped = false;
            for (int i = 0; i < j; i++) {
                if (in[i] > in[i + 1]) {
                    int temp = in[i + 1];
                    in[i + 1] = in[i];
                    in[i] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return in;
    }
}
