package com.otus.homework.sort;

public class MergeSort {

    public static int[] sort(int[] array) {
        mSort(0, array.length - 1, array);
        return array;
    }

    private static void mSort(int l, int r, int[] array) {
        if (l >= r) return;
        int m = (l + r) / 2;
        mSort(l, m, array);
        mSort(m + 1, r, array);
        merge(l, m, r, array);
    }

    private static void merge(int l, int m, int r, int[] array) {
        int[] temp = new int[r - l + 1];
        int k = 0;
        int i = l;
        int j = m + 1;
        while (i <= m || j <= r) {
            if (i > m) {
                temp[k] = array[j];
                j++;
                k++;
            } else if (j > r) {
                temp[k] = array[i];
                i++;
                k++;
            } else {
                if (array[i] <= array[j]) {
                    temp[k] = array[i];
                    i++;
                    k++;
                } else {
                    temp[k] = array[j];
                    j++;
                    k++;
                }
            }
        }
        System.arraycopy(temp, 0, array, l, temp.length);
    }
}
