package DSA.Tree.Binary_search_Tree;

//       50
//      /  \
//    30    70
//   /  \   /  \
//  20   40 60  80

//Since node 50 has two children (30 and 70), we:
//Find the in-order successor (smallest value in the right subtree).
//Replace 50 with the in-order successor.
//Delete the in-order successor.

public class _6_Delete_Node_in_a_BST {

    public TreeNode right(TreeNode root) {
        // Find the minimum value node in the right subtree (in-order successor)
        TreeNode current = root.right;
        while (current != null && current.left != null) {
            current = current.left;
        }
        return current;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // Node to be deleted found
            if (root.left == null && root.right == null) {
                // Case 1: No children (leaf node)
                return null;
            } else if (root.left == null) {
                // Case 2: One child (right child)
                return root.right;
            } else if (root.right == null) {
                // Case 2: One child (left child)
                return root.left;
            } else {
                // Case 3: Two children
                TreeNode successor = right(root); // Find the in-order successor
                root.val = successor.val; // Replace the value
                root.right = deleteNode(root.right, successor.val); // Delete the successor
            }
        }
        return root;
    }
}
