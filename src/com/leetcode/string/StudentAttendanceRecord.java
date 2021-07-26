package com.leetcode.string;

// https://leetcode.com/problems/student-attendance-record-i/submissions/
public class StudentAttendanceRecord {
    public boolean checkRecord(String s) {
        int A = 0, L = 0;
        for (char c : s.toCharArray()) {
            if (c == 'L') {
                L++;
            } else if (c == 'A') {
                A++;
                L = 0;
            } else {
                L = 0;
            }

            if (A >= 2 || L >= 3) return false;
        }

        return true;
    }
}
