package DSA.Linked_List.Double_Linked_List;

public class _6_Remove_duplicates_from_sorted_DLL {
    public Node removeDuplicates(Node head) {

        if (head == null) return null;

        Node dummy = new Node(-1);
        Node dummyPointer = dummy;

        Node i = head;              // current pointer
        Node j = i;                 // keeps last unique node’s value

        // Add the first node
        Node first = new Node(i.data);
        dummyPointer.next = first;
        first.back = dummyPointer;
        dummyPointer = first;

        i = i.next;                 // move i to second node

        while (i != null) {
            if (i.data != j.data) { // new unique element found
                Node current = new Node(i.data);
                dummyPointer.next = current;
                current.back = dummyPointer;
                dummyPointer = current;

                j = i;  // update "last unique" pointer
            }
            i = i.next;
        }

        // unlink dummy
        if (dummy.next != null) dummy.next.back = null;
        return dummy.next;

    }
}
