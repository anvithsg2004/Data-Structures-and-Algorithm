package DSA.LeetCode.Trees;

public class Search_in_a_Binary_Search_Tree {

    //Binary Tree
    public boolean search(TreeNode root, int target) {
        if (root == null) {
            return false;
        }

        if (root.val == target) {
            return true;
        }

        return search(root.left, target) || search(root.right, target);
    }

    //Binary Search Tree
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null){
            return null;
        }

        if (root.val == val) {
            return root;
        }

        if (val < root.val) {
            return searchBST(root.left, val);
        }
        else {
            return searchBST(root.right, val);
        }
    }

    public static void main(String[] args) {

    }
}
