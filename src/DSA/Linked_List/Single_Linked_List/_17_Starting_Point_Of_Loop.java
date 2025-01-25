package DSA.Linked_List.Single_Linked_List;



public class _17_Starting_Point_Of_Loop {

    public static Node20 startPoint(Node20 head) {
        Node20 slow = head;
        Node20 fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;
            }
        }

        return null;
    }

    public static void main(String[] args) {

    }
}
