package DSA.Linked_List.Double_Linked_List;

public class _4_Delete_all_occurrences_of_a_Key_ {
    public static Node deleteAllOccurOfX(Node head, int key) {

        Node dummy = new Node(-1);
        Node dummyPointer = dummy;

        Node temp = head;

        while (temp != null) {

            if (temp.data != key) {
                Node current = new Node(temp.data);
                dummyPointer.next = current;
                current.back = dummyPointer;

                dummyPointer = current;
            }

            temp = temp.next;

        }

        if (dummy.next != null) dummy.next.back = null;

        return dummy.next;

    }
}
