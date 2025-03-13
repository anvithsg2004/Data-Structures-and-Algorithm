package DSA.Linked_List.Double_Linked_List;

public class _2_Reverse {

    public Node reverse(Node head) {

        if (head == null || head.next == null) {
            return head;
        }

        Node prev = null;
        Node current = head;

        while (current != null) {

            prev = current.back;
            current.back = current.next;
            current = current.back;

        }

        return prev.back;
    }
}
