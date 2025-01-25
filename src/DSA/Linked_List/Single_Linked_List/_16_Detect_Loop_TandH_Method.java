package DSA.Linked_List.Single_Linked_List;

class Node18 {
    int data;
    Node20 next;

    public Node18(int data) {
        this.data = data;
        this.next = null;
    }

    public Node18(int data, Node20 next) {
        this.data = data;
        this.next = null;
    }
}

public class _16_Detect_Loop_TandH_Method {

    public static boolean loop(Node20 head) {
        Node20 slow = head;
        Node20 fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

    }
}
