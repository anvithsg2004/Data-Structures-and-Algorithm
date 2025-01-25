package DSA.Linked_List.Single_Linked_List;

import org.w3c.dom.Node;

public class _8_Insert_At_End {

    public static Node3 end(Node3 head, int val) {
        if (head == null) {
            return new Node3(val);
        }

        Node3 temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = new Node3(val);

        return head;
    }

    public static void main(String[] args) {

    }
}
