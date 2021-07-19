package com.leetcode.sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        for (int loop = 0; loop < arr.length-1; loop++) {
            boolean flag = true;
            for (int idx = 0; idx < arr.length-1; idx++) {
                if (arr[idx] > arr[idx+1]) {
                    int temp = arr[idx];
                    arr[idx] = arr[idx+1];
                    arr[idx+1] = temp;
                    flag = false;
                }
            }
            if (flag) return;
        }
    }

    public static void main(String[] args) {
        int[] input = new int[]{9,4,7,2,6,5,3,1,8};
        System.out.println(Arrays.toString(input));
        bubbleSort(input);
        System.out.println(Arrays.toString(input));
    }
}
