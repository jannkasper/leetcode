package com.leetcode.string;

// https://leetcode.com/problems/rotate-string/
public class RotateString {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        String ss = s + s;
        return ss.contains(goal);
    }
}
