package com.leetcode.array;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> result = new LinkedList<>();

        for (int[] item : intervals) {
            if (result.isEmpty() || result.getLast()[1] < item[0]) {
                result.add(item);
            } else {
                result.getLast()[1] = Math.max(result.getLast()[1], item[1]);
            }

        }

        return result.toArray(new int[result.size()][]);

    }
}
