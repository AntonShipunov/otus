package com.otus.homework.sort;

public class HeapSort {

    public static int[] sort(int[] array) {
        for (int i = array.length / 2 + 1; i >= 0; i--) {
            heapify(i, array.length, array);
        }
        for (int j = array.length - 1; j > 0; j--) {
            swap(0, j, array);
            heapify(0, j, array);
        }
        return array;
    }

    private static void heapify(int root, int size, int[] array) {
        int p = root;
        int l = 2 * p + 1;
        int r = l + 1;
        if (l < size && array[l] > array[p]) p = l;
        if (r < size && array[r] > array[p]) p = r;
        if (p == root) return;
        swap(root, p, array);
        heapify(p, size, array);
    }

    private static void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
