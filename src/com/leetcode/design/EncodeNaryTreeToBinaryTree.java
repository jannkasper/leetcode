package com.leetcode.design;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/encode-n-ary-tree-to-binary-tree/
public class EncodeNaryTreeToBinaryTree {
    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<>();
        }
    }

    class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public class Solution {
        public UndirectedGraphNode decode(TreeNode root) {
            UndirectedGraphNode node = new UndirectedGraphNode(root.val);
            TreeNode lastChild = root.left;
            while (lastChild != null) {
                UndirectedGraphNode child = decode(lastChild);
                node.neighbors.add(child);
                lastChild = lastChild.right;
            }

            return node;
        }

        public TreeNode encode(UndirectedGraphNode root) {
            TreeNode node = new TreeNode(root.label);
            TreeNode lastChild = null;
            for (UndirectedGraphNode child : root.neighbors) {
                TreeNode childNode = encode(child);
                if (lastChild == null) {
                    node.left = childNode;
                } else {
                    lastChild.right = childNode;
                }
                lastChild = childNode;
            }
            return node;
        }
    }
}
