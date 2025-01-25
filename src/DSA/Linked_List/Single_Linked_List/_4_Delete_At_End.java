package DSA.Linked_List.Single_Linked_List;

public class _4_Delete_At_End {

    public static Node3 tail(Node3 head) {
        if (head == null || head.next == null) {
            return null;
        }

        Node3 temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }

        temp.next = null;

        return head;
    }

    public static void main(String[] args) {

    }
}
