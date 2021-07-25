package com.leetcode.design;

import java.util.Iterator;

// https://leetcode.com/problems/peeking-iterator/
public class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iterator;
    Integer store;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        this.store = null;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (store != null) return store;
        store = iterator.next();
        return store;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (store != null) {
            int temp = store;
            store = null;
            return temp;
        }
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        if (store != null) return true;
        return iterator.hasNext();
    }
}
