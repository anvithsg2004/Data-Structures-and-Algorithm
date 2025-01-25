package DSA.Linked_List.Single_Linked_List;

public class _21_Delete_the_Middle_Node_of_a_Linked_List {

    public ListNode deleteMiddle(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {

            prev = slow;
            slow = slow.next;
            fast = fast.next.next;

        }

        prev.next = prev.next.next;

        return head;

    }

    public static void main(String[] args) {

    }
}
