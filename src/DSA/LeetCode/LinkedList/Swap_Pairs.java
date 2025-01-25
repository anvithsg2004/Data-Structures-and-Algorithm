package DSA.LeetCode.LinkedList;

class Node19 {
    int val;
    Node19 next;

    public Node19(int data) {
        this.val = data;
    }
}

public class Swap_Pairs {

    public Node19 swapPairs(Node19 head) {

        if (head == null || head.next == null) {
            return head;
        }

        Node19 prev = head;
        Node19 curr = head.next;


        while (curr != null) {
            int temp = prev.val;
            prev.val = curr.val;
            curr.val = temp;

            if (curr.next != null) {
                prev = prev.next.next;
                curr = curr.next.next;
            }
            else {
                break;
            }
        }

        return head;
    }

    public static void main(String[] args) {

    }
}
