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

//class Node {
//    int data;
//    Node next;
//
//    Node(int d) {
//        data = d;
//        next = null;
//    }
//}

class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        next = prev = null;
    }
}

class Solution {
    public Node addNode(Node head, int p, int x) {

        Node before = head;

        int currPoint = 0;

        while (before.next != null) {

            if (currPoint == p) {

                Node data = new Node(x);

                Node next = before.next;

                before.next = data;
                data.next = next;
                data.prev = before;
                next.prev = data;

                return head;

            }

            currPoint++;
            before = before.next;

        }

        return null;

    }
}
