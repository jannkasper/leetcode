package com.leetcode.dynamicProgramming;

// https://leetcode.com/problems/house-robber/
public class HouseRobber {
    public int rob(int[] nums) {
        int incl = nums[0];
        int excl = 0;

        for (int idx = 1; idx < nums.length; idx++) {
            int temp = excl;
            excl = Math.max(excl, incl);
            incl = temp + nums[idx];
        }
        return Math.max(incl, excl);
    }
}
