package com.leetcode.string;

// https://leetcode.com/problems/valid-palindrome/submissions/
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int start = 0, end = s.length()-1;

        while(start < end) {
            while(start < end && !((s.charAt(start) >= 97 && s.charAt(start) <= 122)
                    || (s.charAt(start) >= 48 && s.charAt(start) <= 57))) start++;
            while(start < end && !((s.charAt(end) >= 97 && s.charAt(end) <= 122)
                    || (s.charAt(end) >= 48 && s.charAt(end) <= 57))) end--;

            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }

        return true;
    }
}
