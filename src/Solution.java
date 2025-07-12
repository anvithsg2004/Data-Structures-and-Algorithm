import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class Solution {
    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode middle = getMiddle(head);
        ListNode leftNode = head;
        ListNode rightNode = middle.next;
        middle.next = null;

        leftNode = sortList(leftNode);
        rightNode = sortList(rightNode);

        return sort(leftNode, rightNode);

    }

    public ListNode sort(ListNode leftNode, ListNode rightNode) {

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (leftNode != null && rightNode != null) {
            if (leftNode.val < rightNode.val) {
                temp.next = leftNode;
                leftNode = leftNode.next;
            } else {
                temp.next = rightNode;
                rightNode = rightNode.next;
            }
            temp = temp.next;
        }

        if (leftNode != null) {
            temp.next = leftNode;
        }

        if (rightNode != null) {
            temp.next = rightNode;
        }

        return dummy.next;

    }

    public ListNode getMiddle(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

        }

        return slow;

    }

}
