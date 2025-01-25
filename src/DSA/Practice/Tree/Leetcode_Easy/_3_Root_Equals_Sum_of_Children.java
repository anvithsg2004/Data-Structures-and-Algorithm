package DSA.Practice.Tree.Leetcode_Easy;

public class _3_Root_Equals_Sum_of_Children {

    //Doing the Pre-Order Traversal

    public boolean checkTree(TreeNode root) {
        //Root
        if (root == null) {
            return true;
        }

        //If the both, left and right are null values
        if (root.left == null && root.right == null) {
            return true;
        }

        //If both, left and right are not null values
        if (root.left != null && root.right != null) {
            int sum = root.left.val + root.right.val;
            if (sum == root.val) {
                return true;
            } else {
                return false;
            }
        }

        //If the right is null
        if (root.left != null) {
            if (root.left.val == root.val) {
                return true;
            }
        }

        //If the left is null
        if (root.right != null) {
            if (root.right.val == root.val) {
                return true;
            }
        }

        //Left and Right Nodes

        return checkTree(root.left) && checkTree(root.right);
    }

    public static void main(String[] args) {

    }
}
