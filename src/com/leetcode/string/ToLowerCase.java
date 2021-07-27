package com.leetcode.string;

// https://leetcode.com/problems/to-lower-case/
public class ToLowerCase {
    public String toLowerCase(String s) {
        char[] result = s.toCharArray();
        for(int idx = 0; idx < result.length; idx++) {
            if (result[idx] < 65 || result[idx] > 90) continue;
            result[idx] = (char)((int)result[idx] | ' ');
        }

        return new String(result);
    }
}
