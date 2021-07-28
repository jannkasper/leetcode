package com.leetcode.string;

// https://leetcode.com/problems/decode-ways/
public class DecodeWays {
    public int numDecodings(String s) {

        return numDecodings(s.toCharArray(), 0, new Integer[s.length()]);
    }
    private int numDecodings(char[] s, int idx, Integer[] mem) {
        if (idx == s.length) return 1;
        if (s[idx] == '0') return 0;
        if (mem[idx] != null) return mem[idx];

        int res = numDecodings(s, idx+1, mem);
        if (idx < s.length-1 && (s[idx] == '1' || s[idx] == '2' && s[idx+1] < '7')) {
            res += numDecodings(s, idx+2, mem);
        }

        return mem[idx] = res;
    }
}
