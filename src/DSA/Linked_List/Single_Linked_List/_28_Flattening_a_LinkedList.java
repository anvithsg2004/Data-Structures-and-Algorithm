package DSA.Linked_List.Single_Linked_List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Node {
    int data;
    Node next;
    Node bottom;

    Node(int x) {
        data = x;
        next = null;
        bottom = null;
    }
}

public class _28_Flattening_a_LinkedList {
    public Node flatten(Node head) {

        List<Integer> parentChildValues = new ArrayList<>();

        Node temp = head;

        while (temp != null) {

            Node temp2 = temp;

            while (temp2 != null) {

                parentChildValues.add(temp2.data);

                temp2 = temp2.bottom;

            }

            temp = temp.next;

        }

        Collections.sort(parentChildValues);

        Node dummy = new Node(-1);
        Node dummyPointer = dummy;

        if (parentChildValues.isEmpty()) {
            return dummy.next;
        }

        for (int data : parentChildValues) {
            Node currentNode = new Node(data);
            currentNode.next = null;
            dummyPointer.bottom = currentNode;
            dummyPointer = currentNode;

        }

        return dummy.bottom;

    }
}
