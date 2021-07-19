package com.leetcode.sorting;

import java.util.Arrays;

public class InsertSort {

    public static void insertSort(int[] arr) {
        for (int idx = 1; idx < arr.length; idx++) {
            int key = arr[idx];
            int idx2 = idx-1;
            while (idx2 >= 0 && arr[idx2] > key) {
                arr[idx2+1] = arr[idx2];
                idx2--;
            }
            arr[idx2+1] = key;
        }
    }

    public static void main(String[] args) {
        int[] input = new int[]{9,4,7,2,6,5,3,1,8};
        System.out.println(Arrays.toString(input));
        insertSort(input);
        System.out.println(Arrays.toString(input));
    }
}
