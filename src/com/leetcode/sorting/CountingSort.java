package com.leetcode.sorting;

import java.util.Arrays;

public class CountingSort {

    public static void countingSort(int[] arr, int n) {
        int[] numbers = new int[n+1];

        for (int num : arr) {
            numbers[num]++;
        }

        for (int idx = 1; idx < n+1; idx++) {
            numbers[idx] += numbers[idx-1];
        }

        int[] result = new int[arr.length];

        for (int idx = 0; idx < arr.length; idx++) {
            int num = arr[idx];
            result[numbers[num] - 1] = num;
            numbers[num]--;
        }

        for (int idx = 0; idx < arr.length; idx++) {
            arr[idx] = result[idx];
        }
    }

    public static void main(String[] args) {
        int[] input = new int[]{9,4,7,2,6,5,3,1,8};
        System.out.println(Arrays.toString(input));
        countingSort(input, 9);
        System.out.println(Arrays.toString(input));
    }
}
