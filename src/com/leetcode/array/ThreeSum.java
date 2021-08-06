package com.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/3sum/
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int idx = 0; idx < nums.length-2; idx++) {
            if (nums[idx] > 0) break;
            if (idx > 0 && nums[idx] == nums[idx-1]) continue;
            int start = idx+1, end = nums.length-1;
            int sum = 0 - nums[idx];
            while(start < end) {
                if (nums[start] > sum) break;
                if (nums[start] + nums[end] == sum) {
                    result.add(Arrays.asList(nums[idx], nums[start], nums[end]));
                    while (start < end && nums[start] == nums[start+1]) start++;
                    while (start < end && nums[end] == nums[end-1]) end--;
                    start++;
                    end--;
                } else if (nums[start] + nums[end] < sum) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return result;
    }
}
