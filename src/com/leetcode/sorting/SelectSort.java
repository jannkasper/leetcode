package com.leetcode.sorting;

import java.util.Arrays;

public class SelectSort {

    public static void selectSort(int[] arr) {
        for (int idx = 0; idx < arr.length; idx++) {
            int minIdx = idx;
            for (int idx2 = idx; idx2 < arr.length; idx2++) {
                minIdx = arr[idx2] < arr[minIdx] ? idx2 : minIdx;
            }
            int temp = arr[idx];
            arr[idx] = arr[minIdx];
            arr[minIdx] = temp;
        }

    }

    public static void main(String[] args) {
        int[] input = new int[]{9,4,7,2,6,5,3,1,8};
        System.out.println(Arrays.toString(input));
        selectSort(input);
        System.out.println(Arrays.toString(input));
    }
}
