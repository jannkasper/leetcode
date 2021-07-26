package com.leetcode.string;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/word-pattern/submissions/
public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] array = s.split(" ");
        Map<Character, String> mainMap = new HashMap<>();
        Map<String, Character> supportMap = new HashMap<>();
        if (pattern.length() != array.length) return false;
        for (int idx = 0; idx < pattern.length(); idx++) {
            mainMap.putIfAbsent(pattern.charAt(idx), array[idx]);
            supportMap.putIfAbsent(array[idx], pattern.charAt(idx));

            // Support map check if word was already related to another char
            if (pattern.charAt(idx) != supportMap.get(array[idx])) return false;
            if (!mainMap.get(pattern.charAt(idx)).equals(array[idx])) return false;
        }
        return true;
    }
}
