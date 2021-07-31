package com.leetcode.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/pascals-triangle-ii/
public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> recent = new ArrayList<>();
        recent.add(1);

        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> next = new ArrayList<>();
            next.add(1);
            for (int idx = 0; idx < recent.size()-1; idx++) {
                next.add(recent.get(idx) + recent.get(idx+1));
            }
            next.add(1);

            recent = next;
        }

        return recent;
    }
}
