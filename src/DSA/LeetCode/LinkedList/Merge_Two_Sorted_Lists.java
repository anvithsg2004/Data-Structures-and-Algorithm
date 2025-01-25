package DSA.LeetCode.LinkedList;

class ListNode {
    int val;
    ListNode next;

    public ListNode() {}

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val; this.next = next;
    }
}

public class Merge_Two_Sorted_Lists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode left =  list1;
        ListNode right = list2;

        ListNode head = new ListNode(0);
        ListNode prev = head;

        while (left != null && right != null) {
            if (left.val <= right.val) {
                prev.next = left;
                prev = left;
                left = left.next;
            }
            else {
                prev.next = right;
                prev = right;
                right = right.next;
            }
        }

        if (left != null) {
            prev.next = left;
        }

        if (right != null) {
            prev.next = right;
        }

        return head.next;

    }

    public static void main(String[] args) {

    }
}
