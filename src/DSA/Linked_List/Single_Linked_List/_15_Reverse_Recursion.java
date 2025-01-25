package DSA.Linked_List.Single_Linked_List;

class Node16 {
    int data;
    Node16 next;

    public Node16(int data) {
        this.data = data;
        this.next = null;
    }

    public Node16(int data, Node16 next) {
        this.data = data;
        this.next = null;
    }
}

public class _15_Reverse_Recursion {

    public static Node16 recursion(Node16 head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node16 newHead = recursion(head.next);
        Node16 front = head.next;
        front.next = head;
        head.next = null;

        return newHead;
    }

    public static void main(String[] args) {

    }
}
