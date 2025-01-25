package DSA.Practice.Tree.Leetcode_Medium;

import java.util.ArrayList;

public class _30_Flatten_Binary_Tree_to_Linked_List {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        // Step 1: Store the node values in an ArrayList using preorder traversal
        ArrayList<Integer> newNode = new ArrayList<>();
        preorder(root, newNode);

        // Step 2: Modify the original tree to create the "flattened" tree structure
        TreeNode current = root; // Start with the original root node
        current.val = newNode.get(0); // Set the value of the root to the first element

        // Step 3: Iteratively build the flattened tree using the remaining values
        for (int i = 1; i < newNode.size(); i++) {
            current.left = null; // Set the left child to null
            current.right = new TreeNode(newNode.get(i)); // Set the right child to the next node
            current = current.right; // Move to the next node
        }
    }

    // Helper function to traverse the tree in preorder and store the values
    public void preorder(TreeNode root, ArrayList<Integer> newNode) {
        if (root == null) {
            return;
        }

        newNode.add(root.val); // Add the current node's value
        preorder(root.left, newNode); // Traverse the left subtree
        preorder(root.right, newNode); // Traverse the right subtree
    }

    public static void main(String[] args) {

    }
}
