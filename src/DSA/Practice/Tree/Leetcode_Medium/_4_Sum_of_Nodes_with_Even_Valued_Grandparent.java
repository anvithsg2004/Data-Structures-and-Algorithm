package DSA.Practice.Tree.Leetcode_Medium;

import DSA.Practice.Tree.BFS.TreeNode;

public class _4_Sum_of_Nodes_with_Even_Valued_Grandparent {

    public int sumEvenGrandparent(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int[] sum = new int[1];

        helper(root, sum);

        return sum[0];
    }

    public void helper(TreeNode root, int[] sum) {

        //Pre Order Traversal
        if (root == null) {
            return; // Base case: if the current node is null, return
        }

        //Operation on root node
        // Check if the current node has an even-valued grandparent
        if (root.val % 2 == 0) {
            // Add values of the left and right grandchildren if they exist
            if (root.left != null) {
                if (root.left.left != null) {
                    sum[0] += root.left.left.val;
                }
                if (root.left.right != null) {
                    sum[0] += root.left.right.val;
                }
            }
            if (root.right != null) {
                if (root.right.left != null) {
                    sum[0] += root.right.left.val;
                }
                if (root.right.right != null) {
                    sum[0] += root.right.right.val;
                }
            }
        }

        // Recursive calls for left and right children
        //Left
        helper(root.left, sum);
        //Right
        helper(root.right, sum);
    }

    public static void main(String[] args) {

    }
}
