package com.leetcode.string;

public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int max = Math.max(v1.length, v2.length);
        for (int idx = 0; idx < max; idx++) {
            Integer int1 = idx < v1.length ? Integer.parseInt(v1[idx]) : 0;
            Integer int2 = idx < v2.length ? Integer.parseInt(v2[idx]) : 0;

            if (int1 > int2) {
                return 1;
            } else if (int2 > int1) {
                return -1;
            }
        }
        return 0;
    }

    public static void main (String[] a) {
        CompareVersionNumbers c = new CompareVersionNumbers();
        c.compareVersion("0.1", "1.1");
    }
}
