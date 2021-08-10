package com.leetcode.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

// https://leetcode.com/problems/all-oone-data-structure/
public class AllOoneDataStructure {
    class AllOne {
        HashMap<String, Integer> map;
        TreeMap<Integer, List<String>> countMap;
        /** Initialize your data structure here. */
        public AllOne() {
            map = new HashMap<>();
            countMap = new TreeMap<>();
        }

        /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
        public void inc(String key) {
            int oldCount = map.getOrDefault(key, 0);
            map.put(key, oldCount + 1);

            if (oldCount != 0) {
                List<String> list = countMap.get(oldCount);
                list.remove(key);
                if (list.size() == 0) countMap.remove(oldCount);
            }

            if (!countMap.containsKey(oldCount+1)) {
                countMap.put(oldCount+1, new ArrayList<>());
            }
            countMap.get(oldCount+1).add(key);
        }

        /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
        public void dec(String key) {
            int oldCount = map.get(key);
            map.put(key, oldCount - 1);

            List<String> list = countMap.get(oldCount);
            list.remove(key);
            if (list.size() == 0) countMap.remove(oldCount);

            if (oldCount - 1 == 0) return;

            if (!countMap.containsKey(oldCount-1)) {
                countMap.put(oldCount-1, new ArrayList<String>());
            }
            countMap.get(oldCount-1).add(key);
        }

        /** Returns one of the keys with maximal value. */
        public String getMaxKey() {
            if (map.size() == 0) return "";
            return countMap.get(countMap.lastKey()).get(0);
        }

        /** Returns one of the keys with Minimal value. */
        public String getMinKey() {
            if (map.size() == 0) return "";
            return countMap.get(countMap.firstKey()).get(0);
        }
    }
}
