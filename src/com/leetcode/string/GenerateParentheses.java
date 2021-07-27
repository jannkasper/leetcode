package com.leetcode.string;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/generate-parentheses/
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis(result, new char[n*2], 0, 0, 0, n);
        return result;
    }

    public void generateParenthesis(List<String> result, char[] word, int open, int close, int idx, int max) {
        if (idx == max*2) {
            result.add(new String(word));
            return;
        }

        if (open < max) {
            word[idx] = '(';
            generateParenthesis(result, word, open+1, close, idx+1, max);
        }

        if (close < open) {
            word[idx] = ')';
            generateParenthesis(result, word, open, close+1, idx+1, max);
        }
    }
}
