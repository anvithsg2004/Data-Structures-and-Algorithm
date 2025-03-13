package DSA.Linked_List.Single_Linked_List;

public class _24_Add_Two_Numbers {

    //The digits are stored in reverse order (1's place is at the head).
    //l1 = [2 → 4 → 3]   (represents 342)
    //l2 = [5 → 6 → 4]   (represents 465)

    //[7 → 0 → 8]  (represents 807)

    //Step-by-Step Dry Run
    //Step	l1 Value	l2 Value    Carry	Sum (l1 + l2 + carry)	New Node	    Result Linked List
    //1	    2	        5	        0	    2 + 5 + 0 = 7	        7	            7 →
    //2	    4	        6	        0	    4 + 6 + 0 = 10	        0 (carry=1)	    7 → 0 →
    //3	    3	        4	        1	    3 + 4 + 1 = 8	        8	            7 → 0 → 8

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry == 1) {
            int sum = 0;
            if (l1 != null) {
                sum = sum + l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum = sum + l2.val;
                l2 = l2.next;
            }

            sum = sum + carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            temp.next = node;
            temp = temp.next;

        }

        return dummy.next;
    }
}
