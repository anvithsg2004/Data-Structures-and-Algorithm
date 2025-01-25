package DSA.Practice.Linked_List.Medium;

public class _3_Insert_Greatest_Common_Divisors_in_Linked_List {

    public int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = head;
        ListNode next = head.next;
        while (next != null && prev.next != null) {
            int gcd = findGCD(prev.val, next.val);
            ListNode dummy = new ListNode(gcd);
            prev.next = dummy;
            dummy.next = next;
            prev = next;
            next = next.next;
        }

        return head;

    }

    public static void main(String[] args) {

    }
}
