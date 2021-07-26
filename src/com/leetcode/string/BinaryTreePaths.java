package com.leetcode.string;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-paths/
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return new ArrayList<>();
        return binaryTreePaths(root, new ArrayList<String>(), "");
    }

    public List<String> binaryTreePaths(TreeNode root, List<String> result, String word) {
        if (root.left == null && root.right == null) {
            result.add(word + root.val);
            return result;
        }

        if (root.left != null) binaryTreePaths(root.left, result, word + root.val + "->");
        if (root.right != null) binaryTreePaths(root.right, result, word + root.val + "->");
        return result;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
