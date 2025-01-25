package DSA.Tree.Binary_search_Tree;

import java.util.ArrayList;
import java.util.List;

public class _12_Two_Sum_In_BST {

    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int sum = list.get(low) + list.get(high);
            if (sum == k) {
                return true;
            }else if (sum < k) {
                low++;
            }else {
                high--;
            }
        }

        return false;
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
