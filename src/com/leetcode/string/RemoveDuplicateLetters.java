package com.leetcode.string;

import java.util.Stack;

// https://leetcode.com/problems/remove-duplicate-letters/
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        char[] word = s.toCharArray();
        int[] letters = new int[26];

        for (char ch : word) {
            letters[ch - 'a']++;
        }

        Stack<Character> stack = new Stack<>();
        boolean[] hasLetter = new boolean[26];
        for (int idx = 0; idx < word.length; idx++) {
            while (hasLetter[word[idx] -'a'] == false
                    && !stack.isEmpty() && stack.peek() > word[idx] && letters[stack.peek() - 'a'] > 0) {
                hasLetter[stack.peek() - 'a'] = false;
                stack.pop();
            }

            if (hasLetter[word[idx] - 'a'] == false) {
                letters[word[idx] - 'a']--;
                hasLetter[word[idx] - 'a'] = true;
                stack.push(word[idx]);
            } else {
                letters[word[idx] - 'a']--;
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) sb.insert(0, stack.pop());


        return sb.toString();
    }
}
