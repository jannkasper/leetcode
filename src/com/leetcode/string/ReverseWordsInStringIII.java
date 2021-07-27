package com.leetcode.string;

// https://leetcode.com/problems/reverse-words-in-a-string-iii/
public class ReverseWordsInStringIII {
    public String reverseWords(String s) {
        char[] array = s.toCharArray();
        int start = 0;
        for (int idx = 0; idx < array.length; idx++) {
            if (idx == array.length - 1 || array[idx+1] == ' ') {
                reverseString(array, start, idx);
            } else if (array[idx] == ' ') {
                start = idx+1;
            }
        }
        return String.valueOf(array);
    }

    public void reverseString(char[] s, int start, int end) {
        while (start < end) {
            s[start] ^= s[end];
            s[end] ^= s[start];
            s[start] ^= s[end];
            start++;
            end--;
        }
        return;
    }
}
