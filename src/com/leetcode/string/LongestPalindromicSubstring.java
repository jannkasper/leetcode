package com.leetcode.string;

import java.util.Arrays;

// https://leetcode.com/problems/longest-palindromic-substring/
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        char[] array = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(array, i, i);
            int len2 = expandAroundCenter(array, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return new String(Arrays.copyOfRange(array, start, end + 1));
    }

    public int expandAroundCenter(char[] array, int left, int right) {
        while (left >= 0 && right < array.length && array[left] == array[right]) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
