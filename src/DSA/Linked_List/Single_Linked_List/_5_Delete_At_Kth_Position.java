package DSA.Linked_List.Single_Linked_List;

public class _5_Delete_At_Kth_Position {

    public static Node3 kth(Node3 head, int k) {
        if (head == null) {
            return null;
        }

        if (k == 1) {
            return head.next;
        }

        int count = 0;
        Node3 temp = head;
        Node3 prev = head;
        while (temp != null) {
            count++;
            if (count == k) {
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
