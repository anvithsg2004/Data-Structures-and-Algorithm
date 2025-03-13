package DSA.Tree.Binary_search_Tree;

public class _11_Inorder_Successor_in_BST {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode x) {
        TreeNode successor = null;
        while (root != null) {
            if (x.val >= root.val) {
                root = root.right;
            } else {
                successor = root;
                root = root.left;
            }
        }

        return successor;
    }
}
