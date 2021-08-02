package com.leetcode.array;

// https://leetcode.com/problems/trapping-rain-water/
public class TrappingRainWater {
    public int trap(int[] height) {
        int[] result = new int[height.length];

        int max = 0;
        for (int idx = 0; idx < height.length; idx++) {
            int calc = max - height[idx];
            calc = Math.max(calc, 0);
            result[idx] = calc;
            max = Math.max(max, height[idx]);
        }

        max = 0;
        for (int idx = height.length-1; idx >= 0; idx--) {
            int calc = max - height[idx];
            calc = Math.max(calc, 0);
            result[idx] = Math.min(calc, result[idx]);
            max = Math.max(max, height[idx]);
        }

        int sum = 0;
        for (int idx = 0; idx < result.length; idx++) {
            sum += result[idx];
        }
        return sum;
    }
}
