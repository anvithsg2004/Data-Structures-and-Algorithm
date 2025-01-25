package DSA.Practice.Linked_List.Medium;

import java.util.Arrays;

public class _1_Convert_Sorted_List_to_Binary_Search_Tree {

    public TreeNode helper(int[] arr, int start, int end) {

        if (start >= end) {
            return null;
        }

        int mid = start + (end - start) / 2;

        TreeNode root = new TreeNode(arr[mid]);

        root.left = helper(arr, start, mid - 1);
        root.right = helper(arr, mid + 1, end);

        return root;
    }

    public TreeNode sortedListToBST(ListNode head) {

        int length = 0;

        ListNode current = head;

        while (current != null) {
            length++;
            current = current.next;
        }

        int[] bst = new int[length];
        int index = 0;

        current = head;

        while (current != null) {
            bst[index] = current.val;
            index++;
            current = current.next;
        }

        System.out.println(Arrays.toString(bst));

        int n = bst.length;

        TreeNode root = helper(bst, 0, n - 1);

        return root;
    }

    public static void main(String[] args) {

    }
}
