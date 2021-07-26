package com.leetcode.string;

public class ExcelSheetColumnNumber {
    public int titleToNumber(String columnTitle) {
        int result = 0;
        int power = 0;
        for (int idx = columnTitle.length()-1; idx >= 0; idx--) {
            result += (int)(columnTitle.charAt(idx) - '@') * Math.pow(26, power);
            power++;
        }
        return result;
    }
}
