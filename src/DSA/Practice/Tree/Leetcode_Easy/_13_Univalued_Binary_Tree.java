package DSA.Practice.Tree.Leetcode_Easy;

public class _13_Univalued_Binary_Tree {

    //This question means that every node value should have the same value.
    //Then take the root Value and pass it as the target.
    public boolean isUnivalTree(TreeNode root) {
        return value(root, root.val);
    }

    //Check it with all the node in the tree
    //If any node value is not matching with the target value then return false.

    //Pre Order Traversal
    public boolean value(TreeNode root, int value) {

        //Root
        if (root == null) {
            return true;
        }

        if (root.val != value) {
            return false;
        }

        //Left and Right
        return value(root.left, value) && value(root.right, value);
    }

    public static void main(String[] args) {

    }
}
