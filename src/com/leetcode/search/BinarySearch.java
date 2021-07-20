package com.leetcode.search;

import java.util.Arrays;

public class BinarySearch {

    // Time complexity: O(N*log(N))
    // Space complexity: O(1)
    public static int binarySearch(int[] arr, int value) {
        int start = 0, end = arr.length-1;

        while (start <= end) {
            int mid = (start + end)/2;

            if (arr[mid] == value) {
                return mid;
            } else if (arr[mid] > value) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return arr[end] == value ? end : -1;
    }

    public static int minBinarySearch(int[] arr, int value) {
        int start = 0, end = arr.length-1;

        while (start < end) {
            int mid = (start + end)/2;

            if (arr[mid] >= value) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return arr[end] == value ? end : -1;
    }

    public static int maxBinarySearch(int[] arr, int value) {
        int start = 0, end = arr.length-1;

        while (start < end) {
            int mid = (start + end)/2;

            if (arr[mid] <= value) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }

        return arr[end] == value ? end : -1;
    }

    public static void main(String[] args) {
        int[] input = new int[]{0,1,2,3,4,5,6,7,8,9};
        int value = 2;
        int index = binarySearch(input, value);
        System.out.println(Arrays.toString(input));
        System.out.println("Value: " + value + " is under index: " + index);

        input = new int[]{0,1,2,2,2,2,2,3,4,5,6,7,8,9};
        index = minBinarySearch(input, value);
        System.out.println(Arrays.toString(input));
        System.out.println("Value: " + value + " is under minIndex: " + index);

        index = maxBinarySearch(input, value);
        System.out.println(Arrays.toString(input));
        System.out.println("Value: " + value + " is under maxIndex: " + index);
    }
}
