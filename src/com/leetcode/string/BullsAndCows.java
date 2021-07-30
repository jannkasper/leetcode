package com.leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class BullsAndCows {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] nums = new int[10];

        for (int idx = 0; idx < secret.length(); idx++) {
            int s = secret.charAt(idx) - '0';
            int g = guess.charAt(idx) - '0';

            if (s == g) {
                bulls++;
            } else {
                if (nums[s] < 0) cows++;
                nums[s]++;

                if (nums[g] > 0) cows++;
                nums[g]--;
            }
        }

        return bulls + "A" + cows + "B";
    }

    public String getHint2(String secret, String guess) {
        Map<Character, Integer> map = new HashMap<>();
        int bulls = 0;
        int cows = 0;
        for (int idx = 0; idx < secret.length(); idx++) {
            char s = secret.charAt(idx);
            char g = guess.charAt(idx);

            if (s == g) {
                bulls++;
                continue;
            }

            if (map.getOrDefault(s, 0) < 0) {
                cows++;
            }
            map.put(s, map.getOrDefault(s, 0) + 1);

            if (map.getOrDefault(g, 0) > 0) {
                cows++;
            }
            map.put(g, map.getOrDefault(g, 0) - 1);
        }

        return bulls + "A" + cows + "B";
    }
}
