package com.leetcode.sorting;

import java.util.Arrays;

public class MergeSort {

    public static void mergeSort(int[] arr, int start , int end) {
        if (start < end) {
            int mid = (start + end)/2;

            mergeSort(arr, start, mid);
            mergeSort(arr, mid+1, end);

            merge(arr, start, mid, end);

        }
    }
    public static void merge(int[] arr, int start, int mid, int end) {

        int leftSize = mid - start + 1;
        int rightSize = end - mid;
        int[] tempLeft = new int[leftSize];
        int[] tempRight = new int[rightSize];

        for (int idx = 0; idx < leftSize; idx++) {
            tempLeft[idx] = arr[start + idx];
        }
        for (int idx = 0; idx < rightSize; idx++) {
            tempRight[idx] = arr[mid + 1 + idx];
        }

        int i = 0, j = 0, k = start;

        while (i < leftSize && j < rightSize) {
            if (tempLeft[i] <= tempRight[j]) {
                arr[k++] = tempLeft[i++];
            } else {
                arr[k++] = tempRight[j++];
            }
        }

        while (i < leftSize) {
            arr[k++] = tempLeft[i++];
        }

        while (j < rightSize) {
            arr[k++] = tempRight[j++];
        }
    }

    public static void main(String[] args) {
        int[] input = new int[]{9,4,7,2,6,5,3,1,8};
        System.out.println(Arrays.toString(input));
        mergeSort(input, 0, input.length-1);
        System.out.println(Arrays.toString(input));
    }
}
