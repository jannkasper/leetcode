package com.leetcode.string;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        char[] array = s.toCharArray();
        int startIdx = 0;
        int result = 1;

        for (int idx = 1; idx < array.length; idx++) {
            int position = contains(array, startIdx, idx);
            if (position != -1) {
                startIdx = position+1;
            }
            result = Math.max(result, idx - startIdx + 1);
        }

        return result;
    }

    private int contains(char[] array, int start, int end) {
        for (int idx = start; idx < end; idx++){
            if (array[end] == array[idx]) return idx;
        }
        return -1;
    }
}
