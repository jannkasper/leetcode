package com.leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// https://leetcode.com/problems/minimum-index-sum-of-two-lists/
public class MinimumIndexSumOfTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String,Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        int min_sum = Integer.MAX_VALUE, sum;

        for (int idx = 0; idx < list1.length; idx++) {
            map.put(list1[idx], idx);
        }

        for (int idx = 0; idx< list2.length; idx++) {
            if (map.containsKey(list2[idx])) {
                sum = idx + map.get(list2[idx]);
                if (sum < min_sum) {
                    result.clear();
                    result.add(list2[idx]);
                    min_sum = sum;
                } else if (sum == min_sum) {
                    result.add(list2[idx]);
                }
            }
        }
        return result.toArray(new String[result.size()]);
    }
}
