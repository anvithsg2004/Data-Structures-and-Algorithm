package DSA.Linked_List.Single_Linked_List;

class Node1 {
    int data;
    Node1 next;

    public Node1(int data) {
        this.data = data;
        this.next = null;
    }

    public Node1(int data, Node1 next) {
        this.data = data;
        this.next = next;
    }
}

public class _1_Defining_Node {
    public static void main(String[] args) {
        Node1 node = new Node1(3);
        System.out.println(node.data);
    }
}
