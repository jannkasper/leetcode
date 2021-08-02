package com.leetcode.array;

// https://leetcode.com/problems/first-missing-positive/
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        boolean[] flag = new boolean[nums.length+1];
        for (int num : nums) {
            if (num >= 1 && num < nums.length + 1) flag[num] = true;
        }

        int idx = 1;
        while (idx < nums.length + 1 && flag[idx]) idx++;
        return idx;
    }
}
