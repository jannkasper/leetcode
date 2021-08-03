package com.leetcode.dynamicProgramming;

import java.util.PriorityQueue;

// https://leetcode.com/problems/regular-expression-matching/
public class RegularExpressionMatching {
    public boolean isMatch(String text, String p) {
        if (p.isEmpty()) return text.isEmpty();

        boolean first_match = !text.isEmpty() && (p.charAt(0) == '.' || p.charAt(0) == text.charAt(0));

        if (p.length() >= 2 && p.charAt(1) == '*') {
            return isMatch(text, p.substring(2)) || (first_match && isMatch(text.substring(1), p));
        } else {
            return first_match && isMatch(text.substring(1), p.substring(1));
        }
    }
}
