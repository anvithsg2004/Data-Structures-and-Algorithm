package DSA.Linked_List.Single_Linked_List;

public class _20_Remove_N_th_node_from_the_end_of_a_Linked_List {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null || head.next == null) {
            return null;
        }

        int length = 0;
        ListNode temp = head;

        while (temp != null) {
            length++;
            temp = temp.next;
        }

        int position = length - n;

        // If we are removing the head
        if (position == 0) {
            return head.next;
        }

        ListNode current = head;

        // Traverse to the node before the one to be removed
        while (position > 1) {
            current = current.next;
            position--;
        }

        // Remove the nth node
        current.next = current.next.next;

        return head;

    }

    public static void main(String[] args) {

    }
}
