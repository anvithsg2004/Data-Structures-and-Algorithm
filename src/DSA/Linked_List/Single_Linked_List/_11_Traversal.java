package DSA.Linked_List.Single_Linked_List;

public class _11_Traversal {

    public static void traversal(Node3 head) {
        Node3 temp = head;
        while (temp != null) {
            System.out.println(temp.data + "-->");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {

    }
}
