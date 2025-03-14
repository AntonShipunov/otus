package com.otus.homework.sort;

public class InsertSort {

    public static int[] sort(int[] in) {
        for (int i = 1; i < in.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (in[j] < in[j + 1]) break;
                int temp = in[j + 1];
                in[j + 1] = in[j];
                in[j] = temp;
            }
        }
        return in;
    }

    public static int[] shiftSort(int[] in) {
        int j;
        for (int i = 1; i < in.length; i++) {
            int t = in[i];
            for (j = i - 1; j >= 0; j--) {
                if (in[j] < t) break;
                in[j + 1] = in[j];
            }
            in[j + 1] = t;
        }
        return in;
    }

    public static int[] binarySearchSort(int[] in) {
        for (int i = 1; i < in.length; i++) {
            int t = in[i];
            int index = binaryNearestRight(in, 0, i - 1, t);
            for (int j = i - 1; j >= index; j--) {
                in[j + 1] = in[j];
            }
            in[index] = t;
        }
        return in;
    }

    private static int binaryNearestRight(int[] array, int low, int high, int value) {
        if (low > high) {
            return low;
        }
        int mid = (high + low) / 2;
        if (array[mid] > value) {
            return binaryNearestRight(array, low, mid - 1, value);
        } else {
            return binaryNearestRight(array, mid + 1, high, value);
        }
    }
}
