package com.leetcode.linkedList;

public class ReverseList {

    // Time complexity: O(N)
    // Space complexity: O(1)
    public static Node reverse(Node head) {
        Node dummy = new Node(0);

        while(head != null) {
            Node temp = dummy.next;
            dummy.next = head;

            head = head.next;
            dummy.next.next = temp;
        }

        return  dummy.next;
    }

    public static void main(String[] args) {
        Node head = null;
        for (int i = 10; i > 0; i--) {
            Node node = new Node(i);
            node.next = head;
            head = node;
        }

        Node.print(head);
        head = reverse(head);
        Node.print(head);
    }
}
