package DSA.Linked_List.Single_Linked_List;

class Node20 {
    int data;
    Node20 next;

    public Node20(int data) {
        this.data = data;
        this.next = null;
    }

    public Node20(int data, Node20 next) {
        this.data = data;
        this.next = null;
    }
}

public class _18_Lenght_Of_Loop {

    public static int findLenght(Node20 slow, Node20 fast) {
        int count = 1;
        fast = fast.next;

        while (slow != fast) {
            count++;
            fast = fast.next;
        }

        return count;
    }

    public static int length(Node20 head) {
        Node20 slow = head;
        Node20 fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return findLenght(slow, fast);
            }
        }

        return 0;
    }

    public static void main(String[] args) {

    }
}
