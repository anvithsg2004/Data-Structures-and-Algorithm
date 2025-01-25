package DSA.Practice.Linked_List.Medium;

import java.util.ArrayList;

public class _2_Reorder_List {

    public void reorderList(ListNode head) {
        // Step 1: Convert the linked list into an array of ListNodes
        ArrayList<ListNode> llArray = new ArrayList<>();
        ListNode current = head;

        while (current != null) {
            llArray.add(current);
            current = current.next;
        }

        int n = llArray.size();

        // Step 2: Use two pointers to reorder the list
        ListNode temp = new ListNode(-1); // Dummy node to start the list
        ListNode dummy = temp;            // Pointer to construct the result

        int low = 0, high = n - 1;

        // Step 3: Reorder nodes in alternating fashion
        while (low <= high) {
            if (low == high) { // When there's only one node left, add it
                dummy.next = llArray.get(low);
                dummy = dummy.next;
                dummy.next = null; // Mark the end of the list
                break;
            }

            // Add node from the front of the list
            dummy.next = llArray.get(low);
            dummy = dummy.next;

            // Add node from the end of the list
            dummy.next = llArray.get(high);
            dummy = dummy.next;

            low++;
            high--;
        }

        // Step 4: Update the head to point to the new list's first node
        head = temp.next;

        // Make sure the final node points to null
        dummy.next = null;
    }

    public static void main(String[] args) {

    }
}
