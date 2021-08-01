package com.leetcode.dynamicProgramming;

import java.util.List;

// https://leetcode.com/problems/word-break/
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {

        boolean[] result = new boolean[s.length() +1];
        result[0] = true;

        for (int idx = 1; idx <= s.length(); idx++) {
            for (int start = 0; start < idx; start++) {
                if (result[start] && wordDict.contains(s.substring(start, idx))) {
                    result[idx] = true;
                    break;
                }
            }
        }
        return result[s.length()];
    }
}
