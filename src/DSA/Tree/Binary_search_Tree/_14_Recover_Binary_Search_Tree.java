package DSA.Tree.Binary_search_Tree;

public class _14_Recover_Binary_Search_Tree {

    public TreeNode first;
    public TreeNode prev;
    public TreeNode middle;
    public TreeNode last;

    public void inorder(TreeNode root) {

        if (root == null) {
            return;
        }

        inorder(root.left);

        if (prev != null && (root.val < prev.val)) {

            if (first == null) {
                first = prev;
                middle = root;
            } else {
                last = root;
            }

        }

        prev = root;

        inorder(root.right);

    }

    public void recoverTree(TreeNode root) {

        first = middle = last = null;
        prev = new TreeNode(Integer.MIN_VALUE);

        inorder(root);

        //Case 1: Non-Adjacent Nodes Swapped
        if (first != null && last != null) {
            int t = first.val;
            first.val = last.val;
            last.val = t;
        }//Case 2: Adjacent Nodes Swapped
        else if (first != null && middle != null) {
            int t = first.val;
            first.val = middle.val;
            middle.val = t;
        }

    }
}
