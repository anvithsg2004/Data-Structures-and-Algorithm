package DSA.Linked_List.Single_Linked_List;

public class _25_Add_1_to_a_number_represented_by_LL {

    public int helper(ListNode temp) {
        if (temp == null) {
            return 1;
        }

        int carry = helper(temp.next);
        temp.val = temp.val + carry;
        if (temp.val < 10) {
            return 0;
        }
        temp.val = 0;
        return 1;
    }

    public ListNode addOne(ListNode head) {

        int carry = helper(head);

        if (carry == 1) {
            ListNode newNode = new ListNode(1);
            newNode.next = head;
            head = newNode;
        }

        return head;

    }

    public static void main(String[] args) {

    }
}
