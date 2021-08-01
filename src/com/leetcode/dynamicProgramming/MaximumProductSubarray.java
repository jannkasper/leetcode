package com.leetcode.dynamicProgramming;

// https://leetcode.com/problems/maximum-product-subarray/
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {

        int result = nums[0], left = 0, right = 0;
        int size = nums.length - 1;

        for (int idx = 0; idx < nums.length; idx++) {
            left = (left == 0 ? 1 : left) * nums[idx];
            right = (right == 0 ? 1 : right) * nums[size - idx];
            result = Math.max(result, Math.max(left, right));
        }


        return result;
    }
}
