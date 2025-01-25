package DSA.Practice.Tree.Leetcode_Easy;

public class _20_Diameter_of_Binary_Tree {

    private int maxDiameter = 0;  // To store the maximum diameter found

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // Call helper method to calculate height and update maxDiameter
        height(root);
        return maxDiameter;
    }

    // Helper method to calculate the height of the tree
    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        // The diameter passing through this node is leftHeight + rightHeight
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);

        // Return the height of the current node
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {

    }
}
