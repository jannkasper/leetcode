package com.leetcode.dynamicProgramming;

// https://leetcode.com/problems/house-robber-ii/
public class HouseRobberII {
    public int rob(int[] nums) {
        return Math.max(rob(nums, 0, nums.length-1), rob(nums, 1, nums.length));
    }

    public int rob(int[] nums, int start, int end) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int incl = nums[start];
        int excl = 0;

        for (int idx = start+1; idx < end; idx++) {
            int temp = excl;
            excl = Math.max(excl, incl);
            incl = temp + nums[idx];
        }
        return Math.max(incl, excl);
    }
}
