package DSA.Linked_List.Single_Linked_List;

import java.util.HashMap;
import java.util.Map;

class Node17 {
    int data;
    Node20 next;

    public Node17(int data) {
        this.data = data;
        this.next = null;
    }

    public Node17(int data, Node20 next) {
        this.data = data;
        this.next = null;
    }
}

public class _16_Detect_Loop {

    public static boolean detect(Node20 head) {
        Node20 temp = head;

        Map<Node20, Integer> nodeMap = new HashMap<>();

        while (temp != null) {
            if (nodeMap.containsKey(temp)) {
                return true;
            }
            nodeMap.put(temp, 1);
            temp = temp.next;
        }

        return false;
    }

    public static void main(String[] args) {

    }
}
