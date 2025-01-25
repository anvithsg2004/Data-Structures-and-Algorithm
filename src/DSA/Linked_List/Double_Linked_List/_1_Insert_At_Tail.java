package DSA.Linked_List.Double_Linked_List;

public class _1_Insert_At_Tail {

    public Node insertAtTail(Node head, int k) {

        Node newNode = new Node(k);

        if (head == null) {
            return newNode;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
        newNode.back = current;

        return head;

    }

    public static void main(String[] args) {

    }
}
