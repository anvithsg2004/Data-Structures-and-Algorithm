package DSA.Practice.Tree.BT;

import java.util.HashMap;
import java.util.Map;

public class _4_BST_From_Inorder_Postorder {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inMap = new HashMap<>();

        // Store the index of each value in the inorder traversal for O(1) lookups
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        // Initial call to the recursive function with the correct bounds
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, inMap);
    }

    public TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, Map<Integer, Integer> inMap) {
        // Base case: if the range is invalid, return null
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        // The root is the last element in the current postorder segment
        TreeNode root = new TreeNode(postorder[postEnd]);

        // Find the index of the root in the inorder traversal
        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - inStart; // Number of nodes in the left subtree

        // Recursively build the left and right subtrees
        root.left = buildTree(inorder, inStart, inRoot - 1, postorder, postStart, postStart + numsLeft - 1, inMap);
        root.right = buildTree(inorder, inRoot + 1, inEnd, postorder, postStart + numsLeft, postEnd - 1, inMap);

        return root;
    }

    public static void main(String[] args) {

    }
}
