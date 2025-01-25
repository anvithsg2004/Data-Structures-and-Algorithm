package DSA.Linked_List.Single_Linked_List;

class Node13 {
    int data;
    Node13 next;

    public Node13(int data) {
        this.data = data;
        this.next = null;
    }

    public Node13(int data, Node13 next) {
        this.data = data;
        this.next = null;
    }
}

public class _14_Middle_Element {

    public static Node13 middle(Node13 head) {
        Node13 slow = head;
        Node13 fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {

    }
}
