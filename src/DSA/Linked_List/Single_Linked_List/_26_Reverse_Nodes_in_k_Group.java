package DSA.Linked_List.Single_Linked_List;

public class _26_Reverse_Nodes_in_k_Group {

    public ListNode reverseKGroup(ListNode head, int k) {

        if (k <= 1 || head == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prevGroupEnd = dummy;

        while (true) {

            ListNode kth = getKthNode(prevGroupEnd, k);

            if (kth == null) {
                break;
            }

            ListNode groupStart = prevGroupEnd.next;
            ListNode nextGroupStart = kth.next;

            // reverse k nodes
            ListNode prev = kth.next;
            ListNode curr = groupStart;
            while (curr != nextGroupStart) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            // reconnect
            prevGroupEnd.next = kth;
            prevGroupEnd = groupStart;

        }

        return dummy.next;

    }

    public ListNode getKthNode(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }

}
