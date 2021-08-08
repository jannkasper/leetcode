package com.leetcode.array;

// https://leetcode.com/problems/plus-one/
public class PlusOne {
    public int[] plusOne(int[] digits) {
        for (int idx = digits.length - 1 ; idx >= 0; idx--) {
            digits[idx]++;
            if (digits[idx] == 10) {
                digits[idx] = 0;
            } else {
                break;
            }
        }

        if (digits[0] == 0) {
            int[] copy = new int[digits.length+1];
            copy[0] = 1;
            for (int idx = 0; idx < digits.length; idx++) copy[idx+1] = digits[idx];
            return copy;
        }

        return digits;
    }
}
