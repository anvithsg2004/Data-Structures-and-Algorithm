package DSA.Tree.Binary_search_Tree;

public class _7_Check_if_a_tree_is_a_BST_or_BT {

    public boolean isValidBST(TreeNode root) {
        long min = Integer.MAX_VALUE;
        long max = Integer.MIN_VALUE;
        return valid(root, min, max);
    }

    public boolean valid(TreeNode node, long minVal, long maxVal) {
        if (node == null) {
            return true;
        }

        //It is just the opposite of the condition.
        if (node.val >= maxVal || node.val <= minVal) {
            return false;
        }

        //Left → the next left node should be smaller than the parent node and greater than the minValue.
        //Right → the next right node should be greater than the parent node and smaller than the highest value.
        //     Left                                  Right
        return valid(node.left, minVal, node.val) && valid(node.right, node.val, maxVal);
    }
}
