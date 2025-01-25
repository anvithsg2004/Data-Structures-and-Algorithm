package DSA.LeetCode.LinkedList;

public class Rotate_List {

    public ListNode rotateRight(ListNode head, int k) {

        if (k == 0 || head == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode temp = head;
        int count = 1;

        while (temp.next != null) {
            count++;
            temp = temp.next;
        }

        k =  k % count;

        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        fast.next = head;
        ListNode newHead = slow.next;
        slow.next = null;

        return newHead;
    }

    public static void main(String[] args) {

    }
}
