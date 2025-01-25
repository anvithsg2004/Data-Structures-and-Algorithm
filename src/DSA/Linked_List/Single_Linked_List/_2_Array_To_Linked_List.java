package DSA.Linked_List.Single_Linked_List;

class Node2 {
    int data;
    Node2 next;

    public Node2(int data) {
        this.data = data;
        this.next = null;
    }

    public Node2(int data, Node2 next) {
        this.data = data;
        this.next = null;
    }
}

public class _2_Array_To_Linked_List {

    public static Node2 arrToll(int[] array) {
        Node2 head = new Node2(array[0]);
        Node2 mover = head;

        for (int i = 1; i < array.length; i++) {
            Node2 temp = new Node2(array[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 6, 9, 14, 6};
        Node2 head = arrToll(array);
        System.out.println(head.data);
    }
}
