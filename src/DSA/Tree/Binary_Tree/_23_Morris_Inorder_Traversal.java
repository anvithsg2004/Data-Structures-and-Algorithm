package DSA.Tree.Binary_Tree;

import java.util.ArrayList;
import java.util.List;

public class _23_Morris_Inorder_Traversal {
    public List<Integer> getInorder(TreeNode root) {
        // List to store the
        // inorder traversal result
        List<Integer> inorder = new ArrayList<>();
        // Pointer to the current node,
        // starting from the root
        TreeNode cur = root;

        // Loop until the current
        // node is not NULL
        while (cur != null) {
            // If the current node's
            // left child is NULL
            if (cur.left == null) {
                // Add the value of the current
                // node to the inorder list
                inorder.add(cur.val);
                // Move to the right child
                cur = cur.right;
            } else {
                // If the left child is not NULL,
                // find the predecessor (rightmost node
                // in the left subtree)
                TreeNode prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }

                // If the predecessor's right child
                // is NULL, establish a temporary link
                // and move to the left child
                if (prev.right == null) {
                    prev.right = cur;
                    cur = cur.left;
                } else {
                    // If the predecessor's right child
                    // is already linked, remove the link,
                    // add current node to inorder list,
                    // and move to the right child
                    prev.right = null;
                    inorder.add(cur.val);
                    cur = cur.right;
                }
            }
        }

        // Return the inorder
        // traversal result
        return inorder;
    }
}
