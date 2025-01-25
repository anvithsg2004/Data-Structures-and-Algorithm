package DSA.Practice.Linked_List.Medium;

public class _8_Double_Number_Represented_as_Linked_List {

    public static ListNode reverse(ListNode head) {
        ListNode temp = head;
        ListNode prev = null;

        while (temp != null) {
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }

        head = prev;

        return head;
    }

    public ListNode doubleIt(ListNode head) {

        head = reverse(head);

        ListNode current = head;
        ListNode prev = null;

        int carry = 0;

        while (current != null) {

            int twoTimes = current.val * 2 + carry;

            current.val = twoTimes % 10;
            carry = twoTimes / 10;

            prev = current;
            current = current.next;
        }

        if (carry > 0) {
            prev.next = new ListNode(carry);
        }

        return reverse(head);
    }

    public static void main(String[] args) {

    }
}
