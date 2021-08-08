package com.leetcode.array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

// https://leetcode.com/problems/interval-list-intersections/
public class IntervalListIntersection {
    public int[][] intervalIntersection2(int[][] firstList, int[][] secondList) {
        if (firstList.length == 0 || secondList.length == 0) return new int[0][];
        List<int[]> result = new ArrayList<>();

        for (int f = 0, s = 0; f < firstList.length && s < secondList.length;) {
            int start = Math.max(firstList[f][0], secondList[s][0]);
            int end = Math.min(firstList[f][1], secondList[s][1]);

            if (start <= end) {
                result.add(new int[]{start, end});
            }
            if (firstList[f][1] < secondList[s][1])
                f++;
            else
                s++;
        }

        return result.toArray(new int[0][]);
    }

    class DataTime {
        int time;
        int cost;
        DataTime(int time, int cost) {
            this.time = time;
            this.cost = cost;
        }
    }

    static Comparator<DataTime> c = new Comparator<DataTime>() {
        public int compare(DataTime a, DataTime b) {
            if (a.time == b.time) {
                return a.cost - b.cost;
            }
            return a.time - b.time;
        }
    };

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        PriorityQueue<DataTime> queue = new PriorityQueue<>(c);
        for (int[] item : firstList) {
            queue.add(new DataTime(item[0], 0));
            queue.add(new DataTime(item[1], -1));
        }
        for (int[] item : secondList) {
            queue.add(new DataTime(item[0], 0));
            queue.add(new DataTime(item[1], -1));
        }

        int count = 0;
        List<int[]> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            DataTime item = queue.poll();
            if (item.cost == 0) {
                count++;
                if (count == 2) result.add(new int[]{item.time, -1});
            } else {
                if (count == 2) result.get(result.size()-1)[1] = item.time;
                count--;
                DataTime next = queue.isEmpty() ? null : queue.peek();
                if (next != null && next.cost == 0 && item.time == next.time) {
                    result.add(new int[]{item.time, item.time});
                }
            }
        }


        return result.toArray(new int[0][]);
    }
}
