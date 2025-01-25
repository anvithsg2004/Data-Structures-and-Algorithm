package DSA.LeetCode.LinkedList;

public class Reverse_LL_2_Pointers {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        // Dummy node to handle edge cases where reversal starts from the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode lp = dummy;

        // Move lp to the node just before the left-th node
        for (int i = 1; i < left; i++) {
            lp = lp.next;
        }

        // l will point to the left-th node, r will point to the right-th node
        ListNode l = lp.next;
        ListNode r = l;

        // Move r to the right-th node
        for (int i = left; i < right; i++) {
            r = r.next;
        }
        ListNode rn = r.next;

        // Reverse the sublist
        ListNode prev = null;
        ListNode current = l;
        while (current != rn) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        // Reconnect the reversed sublist back to the original list
        lp.next = prev;
        l.next = rn;

        return dummy.next;
    }


    public static void main(String[] args) {

    }
}
