package DSA.LeetCode.Trees;

import java.util.ArrayList;

public class Minimum_Absolute_Difference_in_BST {

    public int getMinimumDifference(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        inOrder(root, ans);

        int min = Integer.MAX_VALUE;

        for (int i = 1; i < ans.size(); i++) {
            min = Math.min(min, ans.get(i) - ans.get(i - 1));
        }

        return min;
    }

    private void inOrder(TreeNode root, ArrayList<Integer> ans) {
        if (root == null) {
            return;
        }

        inOrder(root.left, ans);
        ans.add(root.val);
        inOrder(root.right, ans);
    }

    public static void main(String[] args) {

    }
}
