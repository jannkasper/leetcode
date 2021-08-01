package com.leetcode.dynamicProgramming;

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


    public int numDecodings2(String s) {
        char[] arr = s.toCharArray();
        if (arr.length == 0) return 0;
        int n = arr.length;
        int[] dp = new int[n+1];
        dp[n] = 1;
        for(int i= n-1; i >= 0; i--)
            if(arr[i]!='0') {
                dp[i]=dp[i+1];
                if(i < n-1 && (arr[i] == '1' || arr[i] == '2' && arr[i+1] < '7')) {
                    dp[i]+=dp[i+2];
                }
            }
        return dp[0];
    }
}
