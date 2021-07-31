package com.leetcode.dynamicProgramming;

// https://leetcode.com/problems/fibonacci-number/
public class FibonacciNumber {
    public int fib(int n) {
        if (n < 2) return n;
        int f0 = 0;
        int f1 = 1;
        int result = 0;
        for (int idx = 2; idx <= n; idx++) {
            result = f0 + f1;
            f0 = f1;
            f1 = result;
        }

        return result;
    }
}
