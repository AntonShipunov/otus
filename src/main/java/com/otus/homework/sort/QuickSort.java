package com.otus.homework.sort;

import java.util.Random;

public class QuickSort {

    public static int[] sort(int[] array) {
        qSort(0, array.length - 1, array);
        return array;
    }

    private static void qSort(int l, int r, int[] array) {
        if (l >= r) return;
        int m = split(l, r, array);
        qSort(l, m - 1, array);
        qSort(m + 1, r, array);
    }

    private static int split(int l, int r, int[] array) {
        int pivotIndex = randomPivot(l, r);
        int pivotValue = array[pivotIndex];
        swap(pivotIndex, r, array);
        int m = l - 1;
        for (int j = l; j <= r; j++) {
            if (array[j] <= pivotValue) {
                m++;
                swap(j, m, array);
            }
        }
        return m;
    }

    private static void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static int medianPivot(int l, int r, int[] array) {
        int mid = (l + r) / 2;
        int a = array[l];
        int b = array[mid];
        int c = array[r];
        if ((a > b && a < c) || (a > c && a < b)) {
            return l;
        }
        else if ((b > a && b < c) || (b > c && b < a)) {
            return mid;
        }
        else {
            return r;
        }
    }

    private static int randomPivot(int l, int r) {
        Random random = new Random();
        return l + random.nextInt(r - l + 1);
    }
}
