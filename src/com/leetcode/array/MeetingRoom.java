package com.leetcode.array;

import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/meeting-rooms/
public class MeetingRoom {
    public class Interval {
      int start, end;
      Interval(int start, int end) {
          this.start = start;
          this.end = end;
      }
    }
    public boolean canAttendMeetings(List<Interval> intervals) {
        List<int[]> list = null;
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        for (int idx = 1; idx < intervals.size(); idx++) {
            if (intervals.get(idx).end <= intervals.get(idx-1).end) return false;
        }

        return true;
    }
}
