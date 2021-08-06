package com.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/combination-sum/
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> mList = new ArrayList<>();
//        Arrays.sort(candidates);
        combinationSum(mList, new ArrayList<Integer>(), candidates, target, 0);
        return mList;
    }

    public void combinationSum(List<List<Integer>> mList, List<Integer> list, int[] c, int target, int idx) {
        if (target == 0) {
            mList.add(new ArrayList<Integer>(list));
            return;
        }

        for (int i = idx; i <c.length; i++) {
            if (c[i] <= target) {
                list.add(c[i]);
                combinationSum(mList, list, c, target-c[i], i);
                list.remove(list.size()-1);
            }
//            else {
//                break;
//            }
        }

        return;
    }
}
