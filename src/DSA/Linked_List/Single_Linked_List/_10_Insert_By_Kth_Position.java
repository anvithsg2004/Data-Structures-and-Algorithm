package DSA.Linked_List.Single_Linked_List;

public class _10_Insert_By_Kth_Position {

    public static Node3 value(Node3 head, int k, int element) {
        if (head == null) {
            return null;
        }

        if (k == 1) {
            return new Node3(element, head);
        }

        Node3 temp = head;
        int count = 0;

        while (temp != null) {
            count++;
            if (count == k - 1) {
                Node3 x = new Node3(element, temp.next);
                temp.next = x;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
