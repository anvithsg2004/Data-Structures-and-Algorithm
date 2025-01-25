package DSA.Practice.Linked_List.Medium;

public class _4_Merge_Nodes_in_Between_Zeros {

    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        ListNode prev = head;
        ListNode next = head.next;

        int sum = 0;

        while (next != null) {
            if (next.val == 0) {
                prev = next;
                temp.next = new ListNode(sum);
                temp = temp.next;
                sum = 0;
            }
            sum = sum + next.val;
            next = next.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {

    }
}
