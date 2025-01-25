package DSA.Practice.Tree.Leetcode_Easy;

public class _5_Search_in_a_Binary_Search_Tree {

    //Remember the Code
    //Very Important for other problems

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        }

        TreeNode left = searchBST(root.left, val);
        if(left != null) {
            return left;
        }

        return searchBST(root.right, val);
    }

    public static void main(String[] args) {

    }
}
