package DSA.Practice.Linked_List.Medium;

public class _7_Remove_Nodes_From_Linked_List {

    //Here we are :-
    //1) We reverse the linked List
    //2) We take the max as the Integer.MIN_VALUE;
    //3) If the next node it greater than the next node then we add it or else
    //we remove the node and make the prev to current next and the current to the next of it.

    public static ListNode reverse(ListNode head) {
        ListNode temp = head;
        ListNode prev = null;

        while (temp != null) {
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }

        head = prev;

        return head;
    }

    public ListNode removeNodes(ListNode head) {

        head = reverse(head);

        int max = Integer.MIN_VALUE;
        ListNode current = head;
        ListNode prev = null;

        while (current != null) {
            if (current.val > max) {
                max = current.val;
                prev = current;
                current = current.next;
            } else {
                prev.next = current.next;
                current = current.next;
            }
        }

        return reverse(head);

    }

    public static void main(String[] args) {

    }
}
