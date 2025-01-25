package DSA.Practice.Tree.Leetcode_Medium;

public class _27_Construct_String_from_Binary_Tree {

    public String tree2str(TreeNode root) {
        StringBuilder path = new StringBuilder();
        buildString(root, path);
        return path.toString();
    }

    public void buildString(TreeNode root, StringBuilder result) {
        // Base case: if the node is null, do nothing
        if (root == null) {
            return;
        }

        // Add the current node's value
        result.append(root.val);

        // If the node has no children, stop here
        if (root.left == null && root.right == null) {
            return;
        }

        // Add the left child (even if it's null)
        result.append("(");
        buildString(root.left, result);
        result.append(")");

        // Add the right child only if it exists
        if (root.right != null) {
            result.append("(");
            buildString(root.right, result);
            result.append(")");
        }
    }
}
