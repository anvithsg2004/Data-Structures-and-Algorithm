package DSA.Linked_List.Single_Linked_List;

class Node3 {
    int data;
    Node3 next;

    public Node3(int data) {
        this.data = data;
        this.next = null;
    }

    public Node3(int data, Node3 next) {
        this.data = data;
        this.next = null;
    }
}

public class _3_Delete_At_Start {

    public static Node3 end(Node3 head) {
        head = head.next;

        return head;
    }

    public static void main(String[] args) {

    }
}
