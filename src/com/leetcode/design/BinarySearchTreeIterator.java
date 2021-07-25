package com.leetcode.design;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/binary-search-tree-iterator/
public class BinarySearchTreeIterator {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    class BSTIterator {

        Stack<Integer> result;

        public BSTIterator(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            result = new Stack<>();

            TreeNode p = root;
            while (p != null || !stack.isEmpty()) {
                if (p != null) {
                    stack.push(p);
                    p = p.right;
                } else {
                    p = stack.pop();
                    result.push(p.val);
                    p = p.left;
                }
            }
        }

        public int next() {
            return result.pop();
        }

        public boolean hasNext() {
            return !result.isEmpty();
        }
    }
}
