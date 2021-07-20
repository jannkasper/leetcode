package com.leetcode.sorting;

import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int[] arr, int start, int end) {

        if (start < end) {
            int mid = partition(arr, start, end);

            quickSort(arr, start, mid - 1);
            quickSort(arr, mid + 1, end);
        }
    }

    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];

        int i = start;

        for (int idx = start; idx < end; idx++){
            if (arr[idx] <= pivot) {
                int swapTemp = arr[i];
                arr[i] = arr[idx];
                arr[idx] = swapTemp;
                i++;
            }
        }

        arr[end] = arr[i];
        arr[i] = pivot;

        return i;
    }

    public static void main(String[] args) {
        int[] input = new int[]{9,4,7,2,6,5,3,1,8};
        System.out.println(Arrays.toString(input));
        quickSort(input, 0, input.length-1);
        System.out.println(Arrays.toString(input));
    }
}
