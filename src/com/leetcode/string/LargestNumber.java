package com.leetcode.string;

import java.util.Arrays;
import java.util.Comparator;

// https://leetcode.com/problems/largest-number/
public class LargestNumber {
    private static class LargerNumberComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        }
    }

    public String largestNumber(int[] nums) {
        String[] array = new String[nums.length];

        for (int idx = 0; idx < nums.length; idx++) {
            array[idx] = String.valueOf(nums[idx]);
        }

        Arrays.sort(array, new LargerNumberComparator());

        if(array[0].equals("0")) return "0";

        StringBuilder sb = new StringBuilder();
        for (String s : array) {
            sb.append(s);
        }

        return sb.toString();
    }
}
