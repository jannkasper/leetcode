package com.leetcode.array;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/4sum-ii/
public class FourSumII {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0 ;
        for (int idx = 0; idx < nums1.length; idx++) {
            for (int idx2 = 0; idx2 < nums2.length; idx2++) {
                int sum = nums1[idx] + nums2[idx2];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        for (int idx = 0; idx < nums3.length; idx++) {
            for (int idx2 = 0; idx2 < nums4.length; idx2++) {
                int sum = -(nums3[idx] + nums4[idx2]);
                result += map.getOrDefault(sum, 0);
            }
        }
        return result;
    }
}
