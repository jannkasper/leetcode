package com.leetcode.string;

// https://leetcode.com/problems/ransom-note/submissions/
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] counter = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            counter[ransomNote.charAt(i) - 'a']++;
        }

        for (int i = 0; i < magazine.length(); i++) {
            counter[magazine.charAt(i) - 'a']--;
        }

        for (int count : counter) {
            if (count > 0) {
                return false;
            }
        }
        return true;
    }
}
