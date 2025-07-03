package DSA.Linked_List.Single_Linked_List;

public class _22_Odd_Even_Linked_List {

    public ListNode oddEvenList(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode odd = new ListNode(-1);
        ListNode oddNode = odd;
        ListNode even = new ListNode(-1);
        ListNode evenNode = even;

        boolean isEven = false;

        ListNode temp = head;

        while (temp != null) {

            if (isEven) {
                ListNode dummy = new ListNode(temp.val);
                evenNode.next = dummy;
                evenNode = evenNode.next;
            } else {
                ListNode dummy = new ListNode(temp.val);
                oddNode.next = dummy;
                oddNode = oddNode.next;
            }

            temp = temp.next;

            isEven = !isEven;

        }

        oddNode.next = even.next;

        return odd.next;

    }
}
