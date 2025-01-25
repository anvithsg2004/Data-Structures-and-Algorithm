package DSA.Linked_List.Single_Linked_List;

public class _6_Delete_Before_Value {

    public static Node3 kth(Node3 head, int element) {
        if (head == null) {
            return head;
        }

        int count = 0;
        Node3 temp = head;
        Node3 prev = head;
        while (temp != null) {
            count = count + temp.data;
            if (count == element) {
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }

        return head;
    }

    public static void main(String[] args) {

    }
}
