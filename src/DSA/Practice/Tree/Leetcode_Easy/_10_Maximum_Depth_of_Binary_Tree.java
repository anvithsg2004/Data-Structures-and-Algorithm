package DSA.Practice.Tree.Leetcode_Easy;

public class _10_Maximum_Depth_of_Binary_Tree {

    //The Best Approach is Level Order Traversal and return the size of the ArrayList, but Space Complexity sucks.

    // Using the Post-Order Traversal
    // Its is just height.
    public int maxDepth(TreeNode root) {
        //Root
        if (root == null) {
            return 0;
        }

        //Left
        int left = maxDepth(root.left);
        //Right
        int right = maxDepth(root.right);

        //Root
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {

    }
}
