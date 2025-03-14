package com.otus.homework.sort;

import java.util.ArrayList;
import java.util.List;

public class ShellSort {

    public static int[] shellSort(int[] in) {
        for (int gap = in.length / 2; gap > 0; gap/=2)
            for (int j = gap; j < in.length; j++) {
                int temp = in[j];
                int i;
                for (i = j; i >= gap && in[i - gap] > temp; i-=gap) {
                    in[i] = in[i - gap];
                }
                in[i] = temp;
            }
        return in;
    }

    public static int[] sedgewickSort(int[] in) {
        int[] gaps = sedgewickGaps(in.length);
        for (int gap : gaps) {
            for (int j = gap; j < in.length; j++) {
                int temp = in[j];
                int i;
                for (i = j; i >= gap && in[i - gap] > temp; i-=gap) {
                    in[i] = in[i - gap];
                }
                in[i] = temp;
            }
        }
        return in;
    }

    public static int[] hibbardSort(int[] in) {
        int[] gaps = hibbardGaps(in.length);
        for (int gap : gaps) {
            for (int j = gap; j < in.length; j++) {
                int temp = in[j];
                int i;
                for (i = j; i >= gap && in[i - gap] > temp; i-=gap) {
                    in[i] = in[i - gap];
                }
                in[i] = temp;
            }
        }
        return in;
    }

    private static int[] hibbardGaps(int length) {
        List<Integer> gaps = new ArrayList<>();
        int k = 1;
        while (true) {
            int gap = (int) Math.pow(2, k) - 1;
            if (gap >= length) break;
            gaps.add(gap);
            k++;
        }

        int[] result = new int[gaps.size()];
        for (int i = 0; i < gaps.size(); i++) {
            result[i] = gaps.get(gaps.size() - 1 - i);
        }
        return result;
    }

    private static int[] sedgewickGaps(int length) {
        List<Integer> gaps = new ArrayList<>();
        int k = 0;
        while (true) {
            int gap;
            if (k % 2 == 0) {
                gap = (int) (9 * Math.pow(2, k) - 9 * Math.pow(2, k / 2.0) + 1);
            } else {
                gap = (int) (8 * Math.pow(2, k) - 6 * Math.pow(2, (k + 1) / 2.0) + 1);
            }
            if (gap >= length) break;
            gaps.add(gap);
            k++;
        }

        int[] result = new int[gaps.size()];
        for (int i = 0; i < gaps.size(); i++) {
            result[i] = gaps.get(gaps.size() - 1 - i);
        }
        return result;
    }

}
