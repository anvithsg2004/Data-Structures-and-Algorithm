package DSA.Linked_List.Double_Linked_List;

public class _3_Delete_all_occurrences_of_Key {
    public static Node deleteAllOccurOfX(Node head, int key) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == key) {

                if (temp == head) {
                    head = head.next;
                }

                Node nextNode = temp.next;
                Node prevnode = temp.back;
                if (nextNode != null) {
                    nextNode.back = prevnode;
                }

                if (prevnode != null) {
                    prevnode.next = nextNode;
                }

                temp = nextNode;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }
}
