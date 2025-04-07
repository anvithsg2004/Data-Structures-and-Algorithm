package DSA.Tree.Binary_Tree;

public class _3_Diameter_Of_Tree {

    static int diameter = 0;

    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);

        // Update the diameter at every node
        diameter = Math.max(diameter, left + right);

        // Return height of current node
        return 1 + Math.max(left, right);
    }

    public static int getDiameter(TreeNode root) {
        diameter = 0; // Reset diameter before calculating
        height(root); // This will update the diameter
        return diameter;
    }
}
