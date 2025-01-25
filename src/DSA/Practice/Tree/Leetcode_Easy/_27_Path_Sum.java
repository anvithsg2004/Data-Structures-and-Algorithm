package DSA.Practice.Tree.Leetcode_Easy;

public class _27_Path_Sum {

    //ChatGPT Approach
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            if (targetSum == root.val) {
                return true;
            }
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }


    //My Approach
    public boolean hasPathSum1(TreeNode root, int targetSum) {
        return hasPathSum(root, 0, targetSum);
    }

    private boolean hasPathSum(TreeNode root, int currentSum, int targetSum) {
        if (root == null) {
            return false;
        }

        // Add the current node's value to the current sum
        currentSum += root.val;

        // If it's a leaf node, check if the current sum matches the targetSum
        if (root.left == null && root.right == null) {
            return currentSum == targetSum;
        }

        // Recur for left and right subtrees with the updated currentSum
        return hasPathSum(root.left, currentSum, targetSum) || hasPathSum(root.right, currentSum, targetSum);
    }
}
