package DSA.Linked_List.Single_Linked_List;

import java.util.HashMap;

public class _30_Copy_List_with_Random_Pointer {

    class Node {
        int val;
        Node next;
        Node random;

        Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        HashMap<Node, Node> map = new HashMap<>();
        Node curr = head;

        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {

            Node cloneNode = map.get(curr);
            cloneNode.next = map.get(curr.next);
            cloneNode.random = map.get(curr.random);

            curr = curr.next;
        }

        return map.get(head);
    }
}
