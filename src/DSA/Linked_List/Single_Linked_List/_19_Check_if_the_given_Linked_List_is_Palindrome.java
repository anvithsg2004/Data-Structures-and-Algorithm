package DSA.Linked_List.Single_Linked_List;

import java.util.Stack;

public class _19_Check_if_the_given_Linked_List_is_Palindrome {

    public boolean isPalindrome(ListNode head) {

        Stack<Integer> nodes = new Stack<>();

        ListNode temp = head;

        while (temp != null) {
            nodes.push(temp.val);
            temp = temp.next;
        }

        temp = head;

        while (temp != null) {
            if (temp.val != nodes.peek()) {
                return false;
            }
            nodes.pop();
            temp = temp.next;
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
