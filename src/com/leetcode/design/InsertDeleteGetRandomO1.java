package com.leetcode.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/insert-delete-getrandom-o1/
public class InsertDeleteGetRandomO1 {
    class RandomizedSet {

        ArrayList<Integer> nums;
        Map<Integer, Integer> locs;
        java.util.Random rand = new java.util.Random();

        /** Initialize your data structure here. */
        public RandomizedSet() {
            nums = new ArrayList<>();
            locs = new HashMap<Integer, Integer>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if(locs.containsKey(val)) {
                return false;
            }
            locs.put(val, nums.size());
            nums.add(val);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if(!locs.containsKey(val)) {
                return false;
            }
            int loc = locs.get(val);
            if (loc < nums.size() - 1 ) { // not the last one than swap the last one with this val
                int lastone = nums.get(nums.size() - 1 );
                nums.set( loc , lastone );
                locs.put(lastone, loc);
            }
            locs.remove(val);
            nums.remove(nums.size() - 1);
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            return nums.get(rand.nextInt(nums.size()));
        }
    }
}
