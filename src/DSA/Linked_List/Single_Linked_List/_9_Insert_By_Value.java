package DSA.Linked_List.Single_Linked_List;

public class _9_Insert_By_Value {

    public static Node3 value(Node3 head, int val, int element) {
        if (head == null) {
            return null;
        }

        if (head.data == val) {
            return new Node3(element, head);
        }

        Node3 temp = head;

        while (temp == head) {
            if (temp.next.data == val) {
                Node3 x = new Node3(element, temp.next);
                temp.next = x;
                break;
            }
        }

        return head;
    }

    public static void main(String[] args) {

    }
}
