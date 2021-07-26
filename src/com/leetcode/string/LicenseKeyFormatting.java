package com.leetcode.string;

// https://leetcode.com/problems/license-key-formatting/
public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String s, int k) {
        // s = s.replace("-", "").toUpperCase();
        // int idx = s.length() % k == 0 ? k : s.length() % k;
        // while(idx < s.length()) {
        //     s = s.substring(0, idx) + "-" + s.substring(idx);
        //     idx += k + 1;
        // }


        // StringBuilder result = new StringBuilder();
        // int count = 0;
        // for (int idx = s.length()-1; idx >= 0; idx--) {
        //     result.insert(0, s.charAt(idx));
        //     count++;
        //     if(count == k && idx > 0) {
        //         result.insert(0, "-");
        //         count = 0;
        //     }
        // }
        // return result.toString();

        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != '-') {
                sb.append(sb.length() % (k + 1) == k ? '-' : "").append(s.charAt(i));
            }
        }
        return sb.reverse().toString().toUpperCase();
    }
}
