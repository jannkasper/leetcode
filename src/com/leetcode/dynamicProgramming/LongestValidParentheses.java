package com.leetcode.dynamicProgramming;

import java.util.Stack;

// https://leetcode.com/problems/longest-valid-parentheses/
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int max = 0;
        int[] dp = new int[s.length()];

        for (int idx = 1; idx < s.length(); idx++) {
            if (s.charAt(idx) == ')') {
                if (s.charAt(idx - 1) == '(') {
                    dp[idx] = (idx >=2 ? dp[idx-2] : 0) + 2;
                } else if ((idx - 1 - dp[idx-1] >= 0) && s.charAt(idx - 1 - dp[idx-1]) == '(') {
                    dp[idx] = dp[idx-1] + (idx - dp[idx-1] >= 2 ? dp[idx - 2 - dp[idx-1]] : 0) + 2;
                }
                max = Math.max(max, dp[idx]);
            }
        }

        return max;
    }

    public int longestValidParentheses2(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int idx = 0; idx < s.length(); idx++) {
            if (s.charAt(idx) == '(') {
                stack.push(idx);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(idx);
                } else {
                    max = Math.max(max, idx - stack.peek());
                }
            }
        }
        return max;
    }
}
