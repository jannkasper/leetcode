package com.leetcode.array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

// https://leetcode.com/problems/employee-free-time/
public class EmployeeFreeTime {
    class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
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

    public List<Interval> employeeFreeTime(int[][] schedule) {
        // Write your code here
        PriorityQueue<DataTime> queue = new PriorityQueue<>(c);

        for (int[] employee : schedule) {
            for (int idx = 0; idx < employee.length; idx += 2) {
                queue.add(new DataTime(employee[idx], 0));
                queue.add(new DataTime(employee[idx+1], -1));
            }
        }
        List<Interval> result = new ArrayList<>();
        int count = 0;
        while (queue.size() > 1) {
            DataTime left = queue.poll();
            DataTime right = queue.peek();

            if (left.cost == 0) {
                count++;
            } else {
                count--;
            }

            if (left.cost == -1) {
                if (count == 0 && right.cost == 0) {
                    result.add(new Interval(left.time, right.time));
                }
            }
        }
        return result;
    }
}
