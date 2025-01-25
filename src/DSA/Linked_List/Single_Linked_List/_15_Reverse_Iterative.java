package DSA.Linked_List.Single_Linked_List;

import java.util.Stack;

class Node14 {
    int data;
    Node14 next;

    public Node14(int data) {
        this.data = data;
        this.next = null;
    }

    public Node14(int data, Node14 next) {
        this.data = data;
        this.next = null;
    }
}

public class _15_Reverse_Iterative {

    public static Node14 reverse(Node14 head) {
        Node14 temp = head;
        Stack<Integer> st = new Stack<>();

        while (temp != null) {
            st.push(temp.data);
            temp = temp.next;
        }

        temp = head;

        while (temp != null) {
            temp.data = st.pop();
            temp = temp.next;
        }

        return head;
    }

    public static void main(String[] args) {

    }
}
