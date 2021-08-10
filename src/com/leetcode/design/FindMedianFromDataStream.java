package com.leetcode.design;

import java.util.LinkedList;
import java.util.PriorityQueue;

// https://leetcode.com/problems/find-median-from-data-stream/
public class FindMedianFromDataStream {
    class MedianFinder {
        PriorityQueue<Integer> min;
        PriorityQueue<Integer> max;

        /** initialize your data structure here. */
        public MedianFinder() {
            LinkedList<Integer> store = new LinkedList<>();
            store.removeFirst();
            min = new PriorityQueue<>((a,b) -> a-b);
            max = new PriorityQueue<>((a,b) -> b-a);
        }

        public void addNum(int num) {
            if (!min.isEmpty() && num > min.peek()) {
                min.add(num);
            } else {
                max.add(num);
            }

            if (max.size() > min.size() && max.size() - min.size() == 2){
                min.add(max.poll());
            } else if (min.size() > max.size()) {
                max.add(min.poll());
            }
        }

        public double findMedian() {
            if (max.size() == min.size()) return ((double)min.peek() + (double)max.peek())/2;

            return max.peek();
        }
    }
}
