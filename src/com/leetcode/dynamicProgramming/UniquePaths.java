package com.leetcode.dynamicProgramming;

// https://leetcode.com/problems/unique-paths/
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        long result = 1;
        int div = 1;
        for (int idx = Math.max(m-1, n-1) + 1; idx <= m+n-2; idx++) {
            result *= idx;
            result /= div;
            div += 1;
        }
        return (int)result;
    }
}
