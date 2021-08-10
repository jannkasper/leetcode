package com.leetcode.design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

// https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/
public class InsertDeleteGetRandomO1DuplicatesAllowed {
    class RandomizedCollection {
        List<Integer> list;
        HashMap<Integer, List<Integer>> map;
        java.util.Random rand = new java.util.Random();

        /** Initialize your data structure here. */
        public RandomizedCollection() {
            this.list = new ArrayList<>();
            this.map = new HashMap<>();
        }

        /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
        public boolean insert(int val) {
            if (map.containsKey(val)) {
                map.get(val).add(list.size());
                list.add(val);
                return false;
            }

            List<Integer> temp = new ArrayList<>();
            temp.add(list.size());
            map.put(val, temp);
            list.add(val);
            return true;
        }

        /** Removes a value from the collection. Returns true if the collection contained the specified element. */
        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }

            List<Integer> posList = map.get(val);
            int pos = posList.get(posList.size()-1);

            if (pos != list.size()-1) {
                List<Integer> otherList = map.get(list.get(list.size()-1));
                int insPos = Collections.binarySearch(otherList, pos);
                insPos = -insPos -1;
                otherList.add(insPos, pos);
                otherList.remove(otherList.size()-1);
                list.set(pos, list.get(list.size()-1));
            }
            list.remove(list.size()-1);
            posList.remove(posList.size()-1);

            if (posList.size() == 0) map.remove(val);


            return true;
        }

        /** Get a random element from the collection. */
        public int getRandom() {
            return list.get(rand.nextInt(list.size()));
        }
    }
}
