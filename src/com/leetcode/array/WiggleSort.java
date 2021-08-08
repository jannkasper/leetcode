package com.leetcode.array;

// https://leetcode.com/problems/wiggle-sort/
public class WiggleSort {
    public void wiggleSort(int[] nums) {
        // write your code here
        for (int idx = 0; idx < nums.length-1; idx++) {
            if (idx%2 == 0) {
                int max = Math.max(nums[idx], nums[idx+1]);
                int min = Math.min(nums[idx], nums[idx+1]);
                nums[idx] = min;
                nums[idx+1] = max;
            } else {
                int max = Math.max(nums[idx], nums[idx+1]);
                int min = Math.min(nums[idx], nums[idx+1]);
                nums[idx] = max;
                nums[idx+1] = min;
            }
        }
    }
}
