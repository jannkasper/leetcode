package com.leetcode.dynamicProgramming;

// https://leetcode.com/problems/maximum-subarray/
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        // Store first element in case the array contain only one element < 0
        int result = nums[0];
        int currentSum = 0;
        for (int index = 0; index < nums.length; index++) {
            currentSum += nums[index];
            result = result > currentSum ? result : currentSum;
            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        return result;
    }
}
