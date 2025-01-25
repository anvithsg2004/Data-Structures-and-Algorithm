package DSA.Linked_List.Single_Linked_List;

public class _7_Insert_At_Front {

    public static Node3 front(Node3 head, int val) {

        Node3 temp = new Node3(val);
        temp.next = head;
        head = temp;

        return head;
    }

    public static void main(String[] args) {

    }
}
