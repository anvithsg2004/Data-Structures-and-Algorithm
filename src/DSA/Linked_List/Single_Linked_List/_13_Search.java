package DSA.Linked_List.Single_Linked_List;

public class _13_Search {

    public static boolean search(Node3 head, int val) {
        Node3 temp = head;
        while (temp != null) {
            if (temp.data == val) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
