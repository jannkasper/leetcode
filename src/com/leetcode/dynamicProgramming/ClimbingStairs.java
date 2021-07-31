package com.leetcode.dynamicProgramming;

// https://leetcode.com/problems/climbing-stairs/
public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n < 3) return n;
        int step1 = 1;
        int step2 = 2;
        int step3 = 0;

        for (int idx = 3; idx <= n; idx++) {
            step3 = step1 + step2;
            step1 = step2;
            step2 = step3;
        }

        return step3;
    }
}
