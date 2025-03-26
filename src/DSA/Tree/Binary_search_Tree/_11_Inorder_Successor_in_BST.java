package DSA.Tree.Binary_search_Tree;

public class _11_Inorder_Successor_in_BST {

    //The inorder successor of a node x in a Binary Search Tree (BST) is the node that comes right
    //after x in an inorder traversal.

    public TreeNode inorderSuccessor(TreeNode root, TreeNode x) {
        TreeNode successor = null;
        while (root != null) {

            //If x is greater than or equal to root.val, it means its successor must be in the right subtree.
            //Move root to root.right.
            if (x.val >= root.val) {
                root = root.right;
            }
            //If x is less than root.val, then root could be a potential successor.
            //Update successor = root.
            //Move root to root.left to see if there's a smaller possible successor.
            else {
                successor = root;
                root = root.left;
            }
        }

        return successor;
    }
}
