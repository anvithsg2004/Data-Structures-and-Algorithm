package DSA.Linked_List.Single_Linked_List;

public class _23_Intersection_of_Two_Linked_Lists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode d1 = headA;
        ListNode d2 = headB;

        while (d1 != d2) {
            if (d1 == null) {
                d1 = headB;
            } else {
                d1 = d1.next;
            }

            if (d2 == null) {
                d2 = headA;
            } else {
                d2 = d2.next;
            }
        }

        return d1;

    }

    public static void main(String[] args) {

    }
}
