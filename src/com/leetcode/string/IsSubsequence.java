package com.leetcode.string;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) return true;
        if (s.length() > t.length()) return false;
        int pointer = 0;
        for (int idx = 0; idx < t.length(); idx++) {
            if (pointer == s.length()) return true;
            if (s.charAt(pointer) == t.charAt(idx)) pointer++;
        }

        return pointer == s.length();
    }
}
