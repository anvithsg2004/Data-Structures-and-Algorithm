package DSA.Linked_List.Single_Linked_List;

public class _12_Length {

    public static int length(Node3 head) {
        int count = 0;
        Node3 temp = head;
        while (temp != null) {
            temp = temp.next;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {

    }
}
