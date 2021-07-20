package com.leetcode.linkedList;

public class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }

    public static void print(Node head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.print("null");
        System.out.println();
    }
}
