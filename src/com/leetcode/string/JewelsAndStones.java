package com.leetcode.string;

import java.util.Arrays;

// https://leetcode.com/problems/jewels-and-stones/
public class JewelsAndStones {
    public int numJewelsInStones(String jewels, String stones) {
        char[] array = jewels.toCharArray();
        Arrays.sort(array);
        int result = 0;
        for (char ch : stones.toCharArray()) {
            if (Arrays.binarySearch(array, ch) >= 0) result++;
        }
        return result;
    }
}
