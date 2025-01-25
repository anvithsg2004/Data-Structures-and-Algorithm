package DSA.Practice.Tree.Leetcode_Easy;

public class _8_Invert_Binary_Tree {

    //Using the Pre-Order Traversal

    public TreeNode invertTree(TreeNode root) {

        //Root
        if (root == null) {
            return null;
        }

        //Swap
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        //Left
        invertTree(root.left);

        //Right
        invertTree(root.right);

        return root;
    }

    public static void main(String[] args) {

    }
}
