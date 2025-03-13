package DSA.Tree.Binary_search_Tree;

public class _5_Insert_a_given_Node_in_Binary_Search_Tree {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        while (true) {
            if (root.val <= val) {
                if (root.right != null) {
                    root = root.right;
                } else {
                    root.right = new TreeNode(val);
                    break;
                }
            } else {
                if (root.left != null) {
                    root = root.left;
                } else {
                    root.left = new TreeNode(val);
                    break;
                }
            }
        }

        return root;
    }

    public TreeNode insert(TreeNode root, int value) {
        if (root == null) {
            return new TreeNode(value); // Create a new node if root is null
        }
        if (value < root.val) {
            root.left = insert(root.left, value); // Insert in left subtree
        } else {
            root.right = insert(root.right, value); // Insert in right subtree
        }
        return root;
    }
}
