package com.leetcode.string;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/restore-ip-addresses/
public class RestoreIpAddress {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        restoreIp(s, result, 0, "", 0);
        return result;
    }

    private void restoreIp(String ip, List<String> result, int idx, String restored, int count) {
        if (count > 4) return;
        if (count == 4 && idx == ip.length()) {
            result.add(restored);
            return;
        }

        for (int i = 1; i < 4; i++) {
            if (idx + i > ip.length()) break;
            String s = ip.substring(idx,idx+i);
            if ((s.startsWith("0") && s.length() > 1) || (i == 3 && Integer.parseInt(s) > 255 )) continue;
            restoreIp(ip, result, idx+i, restored + s + (count == 3 ? "" : "."), count+1);
        }
    }
}
