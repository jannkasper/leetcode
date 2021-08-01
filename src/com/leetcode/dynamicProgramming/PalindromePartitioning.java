package com.leetcode.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/palindrome-partitioning/
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        boolean[][] dp = new boolean[s.length()][s.length()];
        dfs(result, new ArrayList<String>(), s, 0, dp);
        return result;
    }

    public void dfs(List<List<String>> result, List<String> curr, String s, int start, boolean[][] dp) {
        if (start == s.length()) {
            result.add(new ArrayList(curr));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (s.charAt(start) == s.charAt(end) && (end-start <= 2 || dp[start+1][end-1] == true)) {
                dp[start][end] = true;
                curr.add(s.substring(start, end+1));
                dfs(result, curr, s, end+1, dp);
                curr.remove(curr.size()-1);
            }
        }
    }
}
