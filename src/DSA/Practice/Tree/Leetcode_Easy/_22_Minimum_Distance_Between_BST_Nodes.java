package DSA.Practice.Tree.Leetcode_Easy;

import java.util.ArrayList;

public class _22_Minimum_Distance_Between_BST_Nodes {

    public int minDiffInBST(TreeNode root) {
        if (root == null) {
            return 0;
        }

        ArrayList<Integer> result = new ArrayList<>();
        helper(root, result);

        int sum = Integer.MAX_VALUE;

        for (int i = 1; i < result.size(); i++) {
            int minDifference = result.get(i) - result.get(i - 1);
            sum = Math.min(sum, minDifference);
        }

        return sum;
    }

    public void helper(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }

        helper(root.left, result);
        result.add(root.val);
        helper(root.right, result);
    }

    public static void main(String[] args) {

    }
}
