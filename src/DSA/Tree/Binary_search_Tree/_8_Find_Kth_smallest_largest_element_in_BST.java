package DSA.Tree.Binary_search_Tree;

import java.util.ArrayList;
import java.util.List;

public class _8_Find_Kth_smallest_largest_element_in_BST {

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        int kLargest = list.get(list.size() - k);
        int KSmallest = list.get(k - 1);

        return KSmallest;
    }

    public void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    public static void main(String[] args) {

    }
}
