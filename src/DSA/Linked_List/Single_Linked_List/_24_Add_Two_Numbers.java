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
        ListNode list1 = l1;
        ListNode list2 = l2;

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        int carry = 0;

        while (list1 != null || list2 != null || carry != 0) {

            int sum = carry;

            if (list1 != null) {
                sum = sum + list1.val;
                list1 = list1.next;
            }

            if (list2 != null) {
                sum = sum + list2.val;
                list2 = list2.next;
            }

            temp.next = new ListNode(sum % 10);

            carry = sum / 10;

            temp = temp.next;

        }

        temp.next = null;

        return dummy.next;
    }
}
