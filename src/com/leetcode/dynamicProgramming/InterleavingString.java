package com.leetcode.dynamicProgramming;

// https://leetcode.com/problems/interleaving-string/
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        for (int y = 0; y <= s1.length(); y++) {
            for (int x = 0; x <= s2.length(); x++) {
                if (x == 0 && y == 0) {
                    dp[y][x] = true;
                } else if (y == 0) {
                    dp[y][x] = dp[y][x-1] && s2.charAt(x-1) == s3.charAt(x+y-1);
                } else if (x == 0) {
                    dp[y][x] = dp[y-1][x] && s1.charAt(y-1) == s3.charAt(x+y-1);
                } else {
                    dp[y][x] = (dp[y][x-1] && s2.charAt(x-1) == s3.charAt(x+y-1))
                            || (dp[y-1][x] && s1.charAt(y-1) == s3.charAt(x+y-1));
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
