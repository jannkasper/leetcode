package com.leetcode.string;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/letter-combinations-of-a-phone-number/
public class LetterCombinationsOfPhoneNumber {
    final char[][] phone = new char[][]{
            {'a', 'b', 'c'},{'d', 'e', 'f'},{'g', 'h', 'i'},
            {'j', 'k', 'l'},{'m', 'n', 'o'},{'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},{'w', 'x', 'y', 'z'}
    };

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<String>();
        List<String> result = new ArrayList<>();
        letterCombinations(result, new char[digits.length()], digits.toCharArray(), 0);
        return result;
    }

    public void letterCombinations(List<String> result, char[] word, char[] digits, int idx) {
        if (idx == digits.length) {
            result.add(new String(word));
            return;
        }

        for (char ch : phone[digits[idx] - '2']) {
            word[idx] = ch;
            letterCombinations(result, word, digits, idx+1);
        }
    }
}
