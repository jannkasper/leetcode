package com.leetcode.design;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/moving-average-from-data-stream/
public class MovingAverageFromDataStream {
    public class MovingAverage {
        private Queue<Integer> queue;
        private double sum = 0;
        private int size;
        /*
         * @param size: An integer
         */public MovingAverage(int size) {
            // do intialization if necessary
            this.queue = new LinkedList<>();
            this.size = size;
        }

        /*
         * @param val: An integer
         * @return:
         */
        public double next(int val) {
            if (queue.size() == size) {
                sum -= queue.remove();
            }

            queue.offer(val);
            sum += val;

            return (double)sum / queue.size();
        }
    }
}
