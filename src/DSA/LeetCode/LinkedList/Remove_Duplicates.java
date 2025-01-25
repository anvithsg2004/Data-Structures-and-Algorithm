package DSA.LeetCode.LinkedList;

public class Remove_Duplicates {

    public ListNode deleteDuplicates_2(ListNode head) {
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode dum = root;
        ListNode temp = head;

        while(temp != null && temp.next != null) {
            if(temp.next.val == temp.val) {
                while(temp.next != null && temp.next.val == temp.val) {
                    temp = temp.next;
                }
                dum.next = temp.next;
                temp = temp.next;
            } else {
                dum = dum.next;
                temp = temp.next;
            }
        }
        return root.next;
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;

        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {

    }
}
