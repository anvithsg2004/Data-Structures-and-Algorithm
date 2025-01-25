package DSA.Tree.Binary_search_Tree;

public class _4_Ceil {

    public int findCeil(TreeNode root, int x) {
        int ceil = -1;

        while (root != null) {
            if (root.val == x) {
                return root.val; // Return the value if found
            } else if (root.val < x) {
                root = root.right; // Move right
            } else {
                ceil = root.val; // Update ceil
                root = root.left; // Move left
            }
        }

        return ceil; // Return the ceil value or -1 if not found
    }

    public static void main(String[] args) {
        // You can add test cases here
    }
}
