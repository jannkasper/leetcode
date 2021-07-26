package com.leetcode.string;

// https://leetcode.com/problems/reverse-string-ii/
public class ReverseStringII {
    public String reverseStr(String s, int k) {
        char[] array = s.toCharArray();

        int idx = 0;
        while (idx <= array.length - 1) {
            reverseString(array, idx, Math.min(idx + k - 1, array.length - 1));
            idx += 2*k;
        }

        return String.valueOf(array);
    }

    public void reverseString(char[] s, int start, int end) {
        while (start < end) {
            s[start] ^= s[end];
            s[end] ^= s[start];
            s[start] ^= s[end];
            start++;
            end--;
        }
        return;
    }
}
