package DSA.Linked_List.Single_Linked_List;

public class _22_Odd_Even_Linked_List {

    public ListNode oddEvenList(ListNode head) {

        ListNode evenHead = new ListNode(-1);
        ListNode oddHead = new ListNode(-1);

        ListNode evenTail = evenHead;
        ListNode oddTail = oddHead;

        ListNode temp = head;

        boolean isEven = true;

        while (temp != null) {

            if (isEven == true) {
                evenTail.next = temp;
                evenTail = evenTail.next;
            } else {
                oddTail.next = temp;
                oddTail = oddTail.next;
            }

            isEven = !isEven;

            temp = temp.next;

        }

        evenTail.next = oddHead.next;
        oddTail.next = null;

        return evenHead.next;

    }

    public static void main(String[] args) {

    }
}
