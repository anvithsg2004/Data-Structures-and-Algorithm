package DSA.Practice.Linked_List.Medium;

public class _5_Merge_In_Between_Linked_Lists {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

        ListNode prevA = list1;
        ListNode nextA = list1;

        ListNode prevB = list1;
        ListNode nextB = list1;

        int countList1 = 0;
        int countList2 = 0;

        while (nextA.next != null) {

            if (countList1 == a) {
                break;
            }

            countList1++;
            prevA = nextA;
            nextA = nextA.next;
        }

        while (nextB.next != null) {

            countList2++;
            prevB = nextB;
            nextB = nextB.next;

            if (countList2 == b) {
                break;
            }
        }

        System.out.println(a + "" + b);

        prevA.next = list2;

        ListNode tailOfList2 = list2;

        while (tailOfList2.next != null) {
            tailOfList2 = tailOfList2.next;
        }

        System.out.println(tailOfList2.val);
        System.out.println(nextB.val);

        tailOfList2.next = nextB.next;

        return list1;

    }

    public static void main(String[] args) {

    }
}
