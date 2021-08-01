package com.leetcode.dynamicProgramming;

import java.util.List;

// https://leetcode.com/problems/triangle/
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                triangle.get(i).set(j, triangle.get(i).get(j)
                        + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
            }
        }

        return triangle.get(0).get(0);
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        for (int idx = 1; idx < triangle.size(); idx++) {
            List<Integer> temp = triangle.get(idx);
            List<Integer> prev = triangle.get(idx-1);
            temp.set(0, temp.get(0) + prev.get(0));
            temp.set(temp.size()-1, temp.get(temp.size()-1) + prev.get(prev.size()-1));
        }

        for (int idx = 2; idx < triangle.size(); idx++) {
            List<Integer> prev = triangle.get(idx-1);
            List<Integer> temp = triangle.get(idx);
            for (int item = 1; item < idx; item++) {
                temp.set(item, temp.get(item) + Math.min(prev.get(item-1), prev.get(item)));
            }
        }

        int min = Integer.MAX_VALUE;
        for (int idx = 0; idx < triangle.get(triangle.size()-1).size(); idx++) {
            min = Math.min(min, triangle.get(triangle.size()-1).get(idx));
        }
        return min;
    }
}
