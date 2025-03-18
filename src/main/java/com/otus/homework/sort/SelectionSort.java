package com.otus.homework.sort;

public class SelectionSort {

    public static int[] sort(int[] in) {
        for (int i = 0; i < in.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < in.length; j++) {
                if (in[j] < in[min]) min = j;
            }
            if (min != i) {
                int temp = in[i];
                in[i] = in[min];
                in[min] = temp;
            }
        }
        return in;
    }
}
