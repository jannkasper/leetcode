package com.leetcode.string;

// https://leetcode.com/problems/repeated-substring-pattern/
public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        if (s.isEmpty()) return false;
        String pattern = "";
        for (int idx = 0; idx < s.length()-1; idx++) {
            pattern = pattern + s.charAt(idx);
            if (s.length() % pattern.length() != 0) continue;
            if(s.equals(pattern.repeat(s.length()/pattern.length()))) {
                return true;
            }
        }
        return false;
    }
}
