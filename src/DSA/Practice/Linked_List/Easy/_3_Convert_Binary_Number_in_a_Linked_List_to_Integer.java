package DSA.Practice.Linked_List.Easy;

public class _3_Convert_Binary_Number_in_a_Linked_List_to_Integer {

    public int getDecimalValue(ListNode head) {

        int decimalValue = 0; // Initialize the decimal value

        // Traverse the linked list
        ListNode current = head;
        while (current != null) {
            // Shift the current decimal value left by 1 (multiply by 2) and add the current bit
            decimalValue = (decimalValue * 2) + current.val;
            current = current.next;
        }

        return decimalValue; // Return the calculated decimal value

    }

    public static void main(String[] args) {

    }
}
