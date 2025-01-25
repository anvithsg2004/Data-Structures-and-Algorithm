package DSA.Practice.Linked_List.Medium;

import java.util.ArrayList;

public class _9_Maximum_Twin_Sum_of_a_Linked_List {

    public int pairSum(ListNode head) {

        ArrayList<Integer> elements = new ArrayList<>();

        ListNode current = head;

        while (current != null) {
            elements.add(current.val);
            current = current.next;
        }

        int n = elements.size();

        int maxSum = Integer.MIN_VALUE;
        int low = 0;
        int high = n - 1;

        while (low <= high) {

            maxSum = Math.max(maxSum, elements.get(high) - elements.get(low));

            low++;
            high--;
        }

        return maxSum;

    }

    public int pairSum2(ListNode head) {

        int maxSum = Integer.MIN_VALUE;

        ListNode slow = head; // Tortoise
        ListNode fast = head; // Hare

        // Move hare two steps and tortoise one step until hare reaches the end
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = reverse(slow);
        ListNode firstHalf = head;

        while (firstHalf != null && secondHalf != null) {

            maxSum = Math.max(maxSum, firstHalf.val + secondHalf.val);

            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return maxSum;
    }

    public static ListNode reverse(ListNode head) {
        ListNode temp = head;
        ListNode prev = null;

        while (temp != null) {
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }

        head = prev;

        return head;
    }

    public static void main(String[] args) {

    }
}
