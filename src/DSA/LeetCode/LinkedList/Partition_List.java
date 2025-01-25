package DSA.LeetCode.LinkedList;

public class Partition_List {

    public ListNode partition(ListNode head, int x) {
        ListNode beforeHead = new ListNode(0);
        ListNode afterHead = new ListNode(0);
        ListNode before = beforeHead;
        ListNode after = afterHead;

        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = head;
            }
            else {
                after.next = head;
                after = head;
            }
            head = head.next;
        }

        after.next = null;
        before.next = afterHead.next;
        return beforeHead.next;
    }

    public static void main(String[] args) {

    }
}
