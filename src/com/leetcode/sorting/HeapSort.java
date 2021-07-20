package com.leetcode.sorting;

import java.util.Arrays;

public class HeapSort {

    public static void heapSort(int[] arr) {

        int n = arr.length;
        for (int idx = n/2 - 1; idx >= 0; idx--) {
            heapify(arr, n, idx);
        }

        for (int idx = n - 1; idx > 0; idx--) {
            int swapTemp = arr[0];
            arr[0] = arr[idx];
            arr[idx] = swapTemp;
            heapify(arr, idx, 0);
        }
    }

    public static void heapify(int[] arr, int size, int idx) {
        int largest = idx;
        int left = idx*2 + 1;
        int right = idx*2 + 2;

        if (left < size && arr[largest] < arr[left]) {
            largest = left;
        }

        if (right < size && arr[largest] < arr[right]) {
            largest = right;
        }

        if (largest != idx) {
            int tempSwap = arr[idx];
            arr[idx] = arr[largest];
            arr[largest] = tempSwap;

            heapify(arr, size, largest);
        }
    }

    public static void main(String[] args) {
        int[] input = new int[]{9,4,7,2,6,5,3,1,8};
        System.out.println(Arrays.toString(input));
        heapSort(input);
        System.out.println(Arrays.toString(input));
    }
}
