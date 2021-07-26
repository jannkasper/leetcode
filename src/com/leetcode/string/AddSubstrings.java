package com.leetcode.string;

// https://leetcode.com/problems/add-strings/
public class AddSubstrings {
    public String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int i1 = num1.length() - 1;
        int i2 = num2.length() - 1;
        int num = 0;

        while(i1 >= 0 || i2 >= 0) {
            if (i1 >= 0) num += num1.charAt(i1--) - '0';
            if (i2 >= 0) num += num2.charAt(i2--) - '0';

            result.insert(0, (char)('0' + num % 10));
            num = num / 10;
        }

        if (num != 0) {
            result.insert(0, (char)('0' + num));
        }

        return result.toString();
    }
}
