package com.leetcode.string;

// https://leetcode.com/problems/find-the-difference/
public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        int idx = 0;
        int result = 0;
        while (idx < s.length()) result ^= s.charAt(idx++);
        idx = 0;
        while (idx < t.length()) result ^= t.charAt(idx++);
        return (char) result;
    }
}
