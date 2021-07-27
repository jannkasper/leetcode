package com.leetcode.string;

// https://leetcode.com/problems/integer-to-roman/
public class IntegerToRoman {
    final int[] decimal = new int[]{1,4,5,9,10,40,50,90,100,400,500,900,1000};
    final String[] roman = new String[]{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int position = decimal.length-1;
        while(num > 0) {
            if (decimal[position] <= num) {
                sb.append(roman[position]);
                num -= decimal[position];
            } else {
                position--;
            }
        }

        return sb.toString();
    }
}
