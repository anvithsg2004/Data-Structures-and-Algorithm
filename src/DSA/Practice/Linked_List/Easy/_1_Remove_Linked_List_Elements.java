package DSA.Practice.Linked_List.Easy;

public class _1_Remove_Linked_List_Elements {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        ListNode current = head;

        while (current != null) {

            if (current.val != val) {
                tail.next = new ListNode(current.val);
                tail = tail.next;
            }

            current = current.next;

        }

        return dummy.next;
    }

    public static void main(String[] args) {

    }
}
