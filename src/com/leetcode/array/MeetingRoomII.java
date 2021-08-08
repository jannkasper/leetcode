package com.leetcode.array;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

// https://leetcode.com/problems/meeting-rooms-ii/
public class MeetingRoomII {
    public class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

        int result = 0;
        for(Interval i : intervals) {
            if (!queue.isEmpty() && queue.peek() <= i.start) {
                queue.poll();
                queue.add(i.end);
            } else {
                queue.add(i.end);
                result++;
            }
        }
        return result;
    }
}
