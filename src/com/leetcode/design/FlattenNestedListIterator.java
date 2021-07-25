package com.leetcode.design;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/flatten-nested-list-iterator/
public class FlattenNestedListIterator {
    public class NestedIterator implements Iterator<Integer> {

        Stack<NestedInteger> stack = new Stack<>();


        public NestedIterator(List<NestedInteger> nestedList) {
            help(nestedList);
        }

        @Override
        public Integer next() {
            while (!stack.isEmpty() && !stack.peek().isInteger()) {
                help(stack.pop().getList());
            }
            return stack.pop().getInteger();
        }

        @Override
        public boolean hasNext() {
            while (!stack.isEmpty() && !stack.peek().isInteger()) {
                help(stack.pop().getList());
            }
            return !stack.isEmpty();
        }

        public void help(List<NestedInteger> nestedList) {
            for (int idx = nestedList.size() - 1; idx >= 0; idx--) {
                stack.push(nestedList.get(idx));
            }
        }
    }
}

interface NestedInteger {
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();

}
