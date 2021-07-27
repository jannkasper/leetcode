package com.leetcode.string;

// https://leetcode.com/problems/count-binary-substrings/
public class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        int result = 0, prev = 0, cur = 1;
        for (int idx = 1; idx < s.length(); idx++) {
            if (s.charAt(idx) != s.charAt(idx-1)) {
                result += Math.min(prev, cur);
                prev = cur;
                cur = 1;
            } else {
                cur++;
            }
        }
        return result + Math.min(prev, cur);
    }
}
