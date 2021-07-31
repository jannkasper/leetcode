package com.leetcode.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/pascals-triangle/
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> recent = new ArrayList<>();
        recent.add(1);
        result.add(recent);

        for (int i = 2; i <= numRows; i++) {
            List<Integer> next = new ArrayList<>();
            next.add(1);
            for (int idx = 0; idx < recent.size()-1; idx++) {
                next.add(recent.get(idx) + recent.get(idx+1));
            }
            next.add(1);

            result.add(next);
            recent = next;
        }

        return result;
    }
}
