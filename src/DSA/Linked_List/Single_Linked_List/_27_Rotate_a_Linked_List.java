package DSA.Linked_List.Single_Linked_List;

public class _27_Rotate_a_Linked_List {
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int n = lengthOfLL(head);

        ListNode start = head;
        ListNode end = head;

        while (end.next != null) {
            end = end.next;
        }
        end.next = start;

        k = k % n;

        k = n - k;

        ListNode temp = start;

        while (k > 1 && temp != null) {
            k--;
            temp = temp.next;
        }

        ListNode newHead = temp.next;
        temp.next = null;
        return newHead;

    }

    public int lengthOfLL(ListNode head) {

        int count = 0;
        ListNode temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;

    }
}
