package DSA.Linked_List.Single_Linked_List;

class Node15 {
    int data;
    Node15 next;

    public Node15(int data) {
        this.data = data;
        this.next = null;
    }

    public Node15(int data, Node15 next) {
        this.data = data;
        this.next = null;
    }
}

public class _15_Reverse_NO_DS {

    public static Node15 noDs(Node15 head) {
        Node15 temp = head;
        Node15 prev = null;

        while (temp != null) {
            Node15 front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }

        head = prev;

        return head;
    }

    public static void main(String[] args) {

    }
}
