package DSA.Linked_List.Double_Linked_List;

public class _2_Reverse {

    //Input Doubly Linked List
    //1 ⇄ 2 ⇄ 3 ⇄ 4

    //Initial Pointers:
    //head = 1
    //prev = null
    //current = head (1)

    //Final Reversed List
    //4 ⇄ 3 ⇄ 2 ⇄ 1

    public Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node current = head;
        Node temp = null;

        while (current != null) {
            temp = current.back;  // Store back pointer
            current.back = current.next;  // Swap next and back
            current.next = temp;  // Assign temp to next
            current = current.back;  // Move to next node (previously next)
        }

        // At the end, temp is at the old head, so return temp.back
        return temp.back;
    }
}
